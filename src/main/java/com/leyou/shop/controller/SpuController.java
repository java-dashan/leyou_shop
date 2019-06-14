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

    @GetMapping("/{parentid}/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询cid为xxx的spu列表")
    public ResponseEntity<PageResult<Spu>> queryByParentId(@PathVariable("parentid") Long parentid, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(spuService.queryByParentId(parentid, pageNum, pageSize));
    }

    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询spu列表")
    public ResponseEntity<PageResult<Spu>> list(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(spuService.list(null, pageNum, pageSize));
    }

    @GetMapping("/like/{pageNum}/{pageSize}")
    @ApiOperation(value = "根据标题模糊查询")
    public ResponseEntity<PageResult> listLike(@RequestParam("name") String name, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(spuService.listLikeByTitle(name, pageNum, pageSize));
    }

    @GetMapping("/likebybrand/{pageNum}/{pageSize}")
    @ApiOperation(value = "根据品牌模糊查询")
    public ResponseEntity<PageResult> likeByBrand(@RequestParam("brandName") String name, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(spuService.queryByBrandName(name, pageNum, pageSize));
    }

    @GetMapping("/createtime/{pageNum}/{pageSize}")
    @ApiOperation(value = "根据品牌模糊查询")
    public ResponseEntity<PageResult> listByCreateTime(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(spuService.queryByCreateTime(pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation(value = "增加spu")
    public ResponseEntity<Void> insert(@RequestBody Spu spu) {
        spuService.insert(spu);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    @ApiOperation(value = "更改spu")
    public ResponseEntity<Void> update(@RequestBody Spu spu) {
        spuService.update(spu);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除spu")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        spuService.delete(id);
        return ResponseEntity.ok(null);
    }


}
