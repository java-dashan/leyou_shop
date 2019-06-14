package com.leyou.shop.service.mongo;

import com.leyou.shop.model.mongo.Comment;
import com.leyou.shop.util.IdWorker;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;

    /**
     * 列出评论
     *
     * @param spu_id,parent_id
     * @return
     */
    public PageResult<Comment> listP(Integer spu_id, Long parent_id , Integer pageNum, Integer pageSize) {
        Query query = new Query(Criteria.where("parent_id").is(parent_id));
        query.addCriteria(Criteria.where("spu_id").is(spu_id));
        query.skip((pageNum - 1) * pageSize);
        query.limit(pageSize);
        query.with(new Sort(Sort.Direction.DESC,"create_time"));
        List<Comment> comments = mongoTemplate.find(query, Comment.class, "comment");
        Long count = mongoTemplate.count(query, Comment.class, "comment");
        return new PageResult<Comment>(count,(int)(count%pageSize==0?1:count/pageSize+1),comments);
    }

    /**
     * 新增评论
     *
     * @param comment
     */
    public void insert(Comment comment) {
        comment.setId(idWorker.nextId());
        comment.setStar(0);   // 默认点赞数为0
        mongoTemplate.save(comment, "comment");
    }

    /**
     * 更新点赞数   注： mongodb中是   _id
     *
     * @param id
     */
    public void update(Long id,Boolean starflag) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        if(starflag){
            update.inc("star");
        }else {
            update.inc("star",-1);
        }
        mongoTemplate.updateFirst(query, update, "comment");
    }

    /**
     * 删除评论
     *
     * @param id
     */
    public void delete(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, "comment");
    }

}
