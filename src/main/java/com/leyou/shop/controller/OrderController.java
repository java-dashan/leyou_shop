package com.leyou.shop.controller;

import com.leyou.shop.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Api(value = "order Api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(){

    }



}
