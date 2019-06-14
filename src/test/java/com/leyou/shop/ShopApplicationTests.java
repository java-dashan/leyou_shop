package com.leyou.shop;

import com.leyou.shop.model.mongo.Comment;
import com.leyou.shop.pojo.Demo;
import com.leyou.shop.pojo.MongoDemo;
import com.leyou.shop.pojo.Score;
import com.leyou.shop.service.mongo.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    CommentService commentService;

    @Test
    public void moogodbtest(){
        MongoDemo demo = new MongoDemo(1, "a", 11);
        MongoDemo demo1 = new MongoDemo(2, "a", 11);
        MongoDemo demo2 = new MongoDemo(3, "a", 11);
        mongoTemplate.save(demo, "demo");
        mongoTemplate.save(demo1, "demo");
        mongoTemplate.save(demo2, "demo");
        List<MongoDemo> all = mongoTemplate.findAll(MongoDemo.class,"demo");
        System.out.println(all);
        for (MongoDemo mongoDemo : all) {
            System.out.println(mongoDemo.getId()+" : "+mongoDemo.getName()+" : "+mongoDemo.getAge());
        }
    }

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void  test(){
        Object a = stringRedisTemplate.opsForValue().get("a");
        System.out.println((String) a);
        Boolean a1 = stringRedisTemplate.hasKey("a");
        System.out.println(a1);
        stringRedisTemplate.opsForValue()
                .set("b","b");
        System.out.println(stringRedisTemplate.opsForValue().get("b"));
//        Object b = stringRedisTemplate.opsForList().leftPop("list",10,TimeUnit.SECONDS);
//        System.out.println(b);
        List<String> list = stringRedisTemplate.opsForList().range("list", 0, -1);
        System.out.println(list);

    }
    
    @Test
    public void testlist(){
        redisTemplate.opsForValue().set("q","q");
        System.out.println(redisTemplate.opsForValue().get("q"));
        System.out.println("/////////////////////");
        List<Demo> list = new ArrayList<>();
        list.add(new Demo("a"));
        list.add(new Demo("b"));
        list.add(new Demo("c"));
        redisTemplate.opsForList().leftPushAll("list1",list);

        List<Demo> list1 = redisTemplate.opsForList().range("list1", 0, -1);
        System.out.println(list1);
    }

    @Test
    public void testSet(){
        redisTemplate.opsForList().leftPush("list1","d");
        redisTemplate.opsForSet().add("set","1");
        redisTemplate.opsForSet().add("set",2);
        redisTemplate.opsForSet().add("set",3);
        redisTemplate.opsForSet().add("set",4);
        redisTemplate.opsForSet().add("set",4);
        Set set = redisTemplate.opsForSet().members("set");
        System.out.println(set);
    }

    @Test
    public void testZset(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        zSetOperations.add("zset", "z1", 0);
//        zSetOperations.add("zset", "z2", 0);
//        zSetOperations.add("zset", "z3", 0);
//        zSetOperations.add("zset", "z4", 0);
//        zSetOperations.incrementScore("zset", "z1", 1);
        this.incrZset("zset","z6");
        Set zset = zSetOperations.rangeWithScores("zset", 0, -1);
        Iterator iterator = zset.iterator();
        for (Object o : zset) {
            DefaultTypedTuple defaultTypedTuple = (DefaultTypedTuple)o;
            System.out.println(defaultTypedTuple.getValue()+" : "+  defaultTypedTuple.getScore());
        }
        while (iterator.hasNext()){
            DefaultTypedTuple next = (DefaultTypedTuple)iterator.next();
            System.out.println(next.getValue()+" : "+  next.getScore());
        }
            
        System.out.println(zset);
//        Set zset1 = zSetOperations.rangeByScore("zset", 0, 0);
//        System.out.println(zset1);
//        Set zset2 = zSetOperations.reverseRange("zset", 0, -1);
//        System.out.println(zset2);
        Long rank = zSetOperations.rank("zset", "z1");
        Long rank1 = zSetOperations.rank("zset", "z0");
        System.out.println(rank+" :"+ rank1);

    }
    public void incrZset(String  zsetName,String key){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        if (zSetOperations.rank(zsetName, key)==null) {
            zSetOperations.add(zsetName, key, 0);
            return;
        }
        zSetOperations.incrementScore(zsetName, key, 2);
    }

    @Test
    public void testmongoCRUD(){
//       for(int i=0;i<10;i++){
//           Comment comment = new Comment(); //增
//           comment.setCreate_time(new Date());
//           comment.setDetail("第"+i+"条子评论");
//           comment.setParent_id(1138263729549480000L);
//           comment.setSpu_id(2);
//           comment.setUser_id(1);
//           comment.setUser_name("华为G9子评论");
//           commentService.insert(comment);
//           System.out.println(comment);
//       }
        List<Comment> comment = mongoTemplate.findAll(Comment.class, "comment");
        for (Comment comment1 : comment) {
            System.out.println(comment1);
        }
//        commentService.update(1);       改查
//        List<Comment> comments = commentService.listP(1, 0l,1,10);
//        System.out.println(comments.get(0));
//        commentService.delete(1L);       删除
    }
}
