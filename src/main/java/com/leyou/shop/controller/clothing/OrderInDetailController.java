package com.leyou.shop.controller.clothing;

import com.leyou.shop.model.clothing.OrderInDetail;
import com.leyou.shop.service.clothing.OrderInDetailService;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderindetail")
public class OrderInDetailController {
    @Autowired
    private OrderInDetailService orderInDetailService;

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderInDetail>> list(
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ){
        return ResponseEntity.ok(orderInDetailService.list(pageNum,pageSize));
    }

    @GetMapping("/listByCondition/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderInDetail>> listByCondition(
            @RequestParam(name="order_no",required = false) String order_no,
            @RequestParam(name="code",required = false) String code,
            @RequestParam(name="color",required = false) String color,
            @RequestParam(name="size",required = false) String size,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ){
        OrderInDetail orderInDetail = new OrderInDetail();
        orderInDetail.setOrder_no(order_no);
        orderInDetail.setCode(code);
        orderInDetail.setColor(color);
        orderInDetail.setSize(size);
        return ResponseEntity.ok(orderInDetailService.listByCondition(orderInDetail,pageNum,pageSize));
    }

    @PostMapping
    public void insert(@RequestBody OrderInDetail orderInDetail) {
        orderInDetailService.insert(orderInDetail);
    }

    @PutMapping
    public void  update(@RequestBody OrderInDetail orderInDetail){
        orderInDetailService.update(orderInDetail);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") Long id){
        OrderInDetail orderInDetail = new OrderInDetail();
        orderInDetail.setId(id);
        orderInDetailService.delete(orderInDetail);
    }
}
