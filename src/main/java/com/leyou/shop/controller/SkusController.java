package com.leyou.shop.controller;

import com.leyou.shop.model.Skus;
import com.leyou.shop.service.SkusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skus")
@Api(value = "skus Api")
public class SkusController {

    @Autowired
    private SkusService skusService;

    @ApiOperation(value = "查询所有sku")
    @GetMapping
    public List<Skus>  list(){
        return skusService.skusList();
    }

    @ApiOperation(value = "通过id查询商品")
    @GetMapping("/{id}")
    public Skus  select(@PathVariable int id){
        Skus skus =new Skus();
        skus.setSkuid(id);
        return skusService.query(skus);
    }
}
