package com.leyou.shop.controller.clothing;

import com.leyou.shop.model.clothing.OrderIn;
import com.leyou.shop.service.clothing.OrderInService;
import com.leyou.shop.util.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orderin")
public class OrderInController {
    @Autowired
    private OrderInService orderInService;

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderIn>> list(
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        return ResponseEntity.ok(orderInService.list(pageNum, pageSize));
    }

    @GetMapping("/listByCondition/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderIn>> listByCondition(
            @RequestParam(name = "order_no", required = false) String order_no,
//            @RequestParam(name = "start_date", required = false) Date start_date,
//            @RequestParam(name = "end_date", required = false) Date end_date,
            @RequestParam(name = "person", required = false) String person,
            @RequestParam(name = "warehouse", required = false) Integer warehouse,
            @RequestParam(name = "befrom", required = false) String befrom,
            @RequestParam(name = "remark", required = false) String remark,
            @RequestParam(name = "flag", required = false) Boolean flag,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) {
        OrderIn orderIn = new OrderIn();
        if (StringUtils.isNotEmpty(order_no)){orderIn.setOrder_no(order_no);}
        if (StringUtils.isNotEmpty(person)){orderIn.setPerson(person);}
        if (StringUtils.isNotEmpty(remark)){orderIn.setRemark(remark);}
        if(StringUtils.isNotEmpty(befrom)){orderIn.setBefrom(befrom);}
        orderIn.setFlag(flag);
        orderIn.setWarehouse(warehouse);
        return ResponseEntity.ok(orderInService.listByCondition(orderIn, pageNum, pageSize));
    }

    @PostMapping
    public void insert(@RequestBody OrderIn orderIn) {
        orderInService.insert(orderIn);
    }

    @PutMapping
    public void update(@RequestBody OrderIn orderIn) {
        orderInService.update(orderIn);
    }

    @DeleteMapping
    public void delete(@RequestParam(  "order_no" ) String order_no) {
        OrderIn orderIn = new OrderIn();
        orderIn.setOrder_no(order_no);
        orderInService.delete(orderIn);
    }
}
