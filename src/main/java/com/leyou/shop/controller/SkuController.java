package com.leyou.shop.controller;

import com.leyou.shop.model.Skus;
import com.leyou.shop.service.SkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skus")
@Api(value = "skus Api")
public class SkuController {

    @Autowired
    private SkuService skuService;

//    @ApiOperation(value = "查询所有sku")
//    @GetMapping
//    public List<Skus>  list(){
//
//        return skusService.skusListByspuId();
//    }

    @ApiOperation(value = "通过spu_id查询商品")
    @GetMapping("/{spu_id}")
    public List<Skus>  select(@PathVariable("spu_id") int spu_id){
        Skus skus =new Skus();
        skus.setSpuid(spu_id);
        return skuService.skusListByspuId(skus);
    }
}
