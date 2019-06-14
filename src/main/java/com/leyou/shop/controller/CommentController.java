package com.leyou.shop.controller;

import com.leyou.shop.controller.req.Star;
import com.leyou.shop.model.mongo.Comment;
import com.leyou.shop.service.mongo.CommentService;
import com.leyou.shop.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{spu_id}/{parent_id}/{pageNum}/{pageSize}")
    @ApiOperation(value = "通过spuid,parent_id进行分页查询")
    public ResponseEntity<PageResult<Comment>> query(
            @PathVariable("spu_id") Integer spu_id,
            @PathVariable("parent_id") Long parent_id,
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(commentService.listP(spu_id, parent_id, pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation(value = "增加评论")
    public ResponseEntity<Void> insert(@RequestBody Comment comment) {
        commentService.insert(comment);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    @ApiOperation(value = "更新点赞数")
    public ResponseEntity<Void> updateStar(@RequestBody Star star) {
        commentService.update(star.getId(),star.getStarflag());
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{_id}")
    @ApiOperation(value = "删除评论")
    public ResponseEntity<Void> delete(@PathVariable("_id") Long _id) {
        commentService.delete(_id);
        return ResponseEntity.ok(null);
    }

}
