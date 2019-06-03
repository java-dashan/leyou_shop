package com.leyou.shop.controller;

import com.leyou.shop.model.Category;
import com.leyou.shop.service.CategoryService;
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
@RequestMapping("/category")
@Api
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{parentid}")
    @ApiOperation(value = "查询二级目录")
    public ResponseEntity<List<Category>> listSecond(@PathVariable("parentid") Long parentid){
        Category category = new Category();
        category.setParent_id(parentid);
        return ResponseEntity.ok(categoryService.list(category));
    }

    @GetMapping
    @ApiOperation(value = "查询一级目录")
    public ResponseEntity<List<Category>> listFirst(){
        Category category = new Category();
        category.setIs_parent(true);
        return ResponseEntity.ok(categoryService.list(category));
    }


}
