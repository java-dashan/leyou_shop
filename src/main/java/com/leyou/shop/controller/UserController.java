package com.leyou.shop.controller;

import com.leyou.shop.controller.req.UserReq;
import com.leyou.shop.model.User;
import com.leyou.shop.service.UserService;
import com.leyou.shop.util.IdWorker;
import com.leyou.shop.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "user API")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "登陆user")
    @PostMapping("/login")
    public ResponseEntity<User> query(@RequestBody UserReq userReq) {
//        System.out.println(isremeber);
        User user = new User();
        user.setUsername(userReq.getUsername());
        User user1 = userService.query(user);
        if (user1 != null && user1.getPassword().equals(userReq.getPassword())) {
            return ResponseEntity.ok(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ApiOperation(value = "查询所有user")
    @GetMapping
    public ResponseEntity<PageResult<User>> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(userService.list(pageNum, pageSize));
    }

    @ApiOperation(value = "通过名字查询")
    @GetMapping("/name")
    public ResponseEntity<PageResult<User>> listByName(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("name") String name) {
        return ResponseEntity.ok(userService.listByName(pageNum, pageSize ,name));
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody User user) {
        user.setId(idWorker.nextId());
        user.setCreated(new Date());
        userService.save(user);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return ResponseEntity.ok(null);
    }


}
