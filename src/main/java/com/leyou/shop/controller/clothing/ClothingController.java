package com.leyou.shop.controller.clothing;

import com.leyou.shop.model.clothing.Clothing;
import com.leyou.shop.service.clothing.ClothingService;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    private ClothingService clothingService;

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<Clothing>> list(
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        return ResponseEntity.ok(clothingService.list(pageNum, pageSize));
    }

    @GetMapping("/listByCondition/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<Clothing>> listByCondition(
            @RequestParam(name = "size", required = false) String size,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "code", required = false) String code,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        Clothing clothing = new Clothing();
        clothing.setCode(code);
        clothing.setColor(color);
        clothing.setSize(size);
        return ResponseEntity.ok(clothingService.listByCondition(clothing, pageNum, pageSize));
    }

    @PostMapping
    public void insert(@RequestBody Clothing clothing) {
        clothingService.insert(clothing);
    }

    @PutMapping
    public void update(@RequestBody Clothing clothing) {
        clothingService.update(clothing);
    }

    @DeleteMapping
    public void delete(@RequestParam("code") String code, @RequestParam("color") String color, @RequestParam("size") String size) {
        Clothing clothing = new Clothing();
        clothing.setCode(code);
        clothing.setColor(color);
        clothing.setSize(size);
        clothingService.delete(clothing);
    }
}
