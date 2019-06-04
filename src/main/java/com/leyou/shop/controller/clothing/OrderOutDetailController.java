package com.leyou.shop.controller.clothing;

import com.leyou.shop.model.clothing.OrderOutDetail;
import com.leyou.shop.service.clothing.OrderOutDetailService;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderoutdetail")
public class OrderOutDetailController {

    @Autowired
    private OrderOutDetailService orderOutDetailService;

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderOutDetail>> list(
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        return ResponseEntity.ok(orderOutDetailService.list(pageNum, pageSize));
    }

    @GetMapping("/listByCondition/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderOutDetail>> listByCondition(
            @RequestParam(name="order_no",required = false) String order_no,
            @RequestParam(name="code",required = false) String code,
            @RequestParam(name="color",required = false) String color,
            @RequestParam(name="size",required = false) String size,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        OrderOutDetail orderOutDetail = new OrderOutDetail();
        orderOutDetail.setOrder_no(order_no);
        orderOutDetail.setCode(code);
        orderOutDetail.setColor(color);
        orderOutDetail.setSize(size);
        return ResponseEntity.ok(orderOutDetailService.listByCondition(orderOutDetail, pageNum, pageSize));
    }

    @PostMapping
    public void insert(@RequestBody OrderOutDetail orderOutDetail) {
        orderOutDetailService.insert(orderOutDetail);
    }

    @PutMapping
    public void update(@RequestBody OrderOutDetail orderOutDetail) {
        orderOutDetailService.update(orderOutDetail);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") Long id){
        OrderOutDetail orderOutDetail = new OrderOutDetail();
        orderOutDetail.setId(id);
        orderOutDetailService.delete(orderOutDetail);
    }
}
