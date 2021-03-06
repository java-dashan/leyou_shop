package com.leyou.shop.controller;

import com.leyou.shop.model.Skus;
import com.leyou.shop.model.Spu;
import com.leyou.shop.service.SkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spu_id", value = "spuid", required = true, dataType = "int", paramType = "query"),//描述
    })
    public List<Skus>  select(@PathVariable("spu_id") int spu_id){
        Skus skus =new Skus();
        skus.setSpuid(spu_id);
        return skuService.skusListByspuId(skus);
    }

    @PostMapping
    @ApiOperation(value = "增加sku")
    public ResponseEntity<Void> insert(@RequestBody Skus sku) {
        skuService.insert(sku);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    @ApiOperation(value = "更改sku")
    public ResponseEntity<Void> update(@RequestBody Skus sku) {
        skuService.update(sku);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除sku")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        skuService.delete(id);
        return ResponseEntity.ok(null);
    }
}
