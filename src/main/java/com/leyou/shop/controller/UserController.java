package com.leyou.shop.controller;

import com.leyou.shop.model.User;
import com.leyou.shop.service.UserService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<User> query(User user){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
