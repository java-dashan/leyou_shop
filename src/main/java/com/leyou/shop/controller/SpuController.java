package com.leyou.shop.controller;

import com.leyou.shop.model.Spu;
import com.leyou.shop.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spu")
@Api(value = "spu Api")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/{parentid}")
    @ApiOperation(value = "查询cid为xxx的商品列表")
    public ResponseEntity<List<Spu>> queryByParentId(@PathVariable("parentid") Long parentid){
        return ResponseEntity.ok(spuService.queryByParentId(parentid));
    }

    @GetMapping
    @ApiOperation(value = "查询商品列表")
    public ResponseEntity<List<Spu>> list(){
        return ResponseEntity.ok(spuService.list(null));
    }



}
