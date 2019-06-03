package com.leyou.shop.controller;

import com.leyou.shop.model.Spu;
import com.leyou.shop.service.SpuService;
import com.leyou.shop.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spu")
@Api(value = "spu Api")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/{parentid}")
    @ApiOperation(value = "查询cid为xxx的spu列表")
    public ResponseEntity<PageResult<Spu>> queryByParentId(@PathVariable("parentid") Long parentid,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize")int pageSize){
        return ResponseEntity.ok(spuService.queryByParentId(parentid, pageNum,pageSize));
    }

    @GetMapping
    @ApiOperation(value = "查询spu列表")
    public ResponseEntity<PageResult<Spu>> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize")int pageSize){
        return ResponseEntity.ok(spuService.list(null, pageNum,pageSize));
    }

    @GetMapping("/page")
    @ApiOperation(value = "模糊查询")
    public ResponseEntity<PageResult> listLike(@RequestParam("name") String name, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize")int pageSize){
        return ResponseEntity.ok(spuService.listLike(name,pageNum,pageSize));
    }




}
