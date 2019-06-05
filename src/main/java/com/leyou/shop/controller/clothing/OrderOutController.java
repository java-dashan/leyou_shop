package com.leyou.shop.controller.clothing;

import com.leyou.shop.model.clothing.OrderOut;
import com.leyou.shop.service.clothing.OrderOutService;
import com.leyou.shop.util.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/orderout")
public class OrderOutController {
    @Autowired
    private OrderOutService orderOutService;

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderOut>> list(
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ){
        return ResponseEntity.ok(orderOutService.list(pageNum,pageSize));
    }

    @GetMapping("/listByCondition/{pageNum}/{pageSize}")
    public ResponseEntity<PageResult<OrderOut>> listByCondition(
            @RequestParam(name="order_no",required = false) String order_no,
//            @RequestParam(name = "start_date", required = false) Date start_date,
//            @RequestParam(name = "end_date", required = false) Date end_date,
            @RequestParam(name = "person", required = false) String person,
            @RequestParam(name = "tel", required = false) String tel,
            @RequestParam(name = "rperson", required = false) String rperson,
            @RequestParam(name = "warehouse", required = false) Integer warehouse,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "remark", required = false) String remark,
            @RequestParam(name = "flag", required = false) Boolean flag,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ){
        OrderOut orderOut = new OrderOut();
        if (StringUtils.isNotEmpty(order_no)){orderOut.setOrder_no(order_no);}
        if (StringUtils.isNotEmpty(person)){orderOut.setPerson(person);}
        if (StringUtils.isNotEmpty(remark)){orderOut.setRemark(remark);}
        if(StringUtils.isNotEmpty(address)){orderOut.setAddress(address);}
        if(StringUtils.isNotEmpty(tel)){orderOut.setTel(tel);}
        if(StringUtils.isNotEmpty(rperson)){ orderOut.setRperson(rperson);}
        orderOut.setFlag(flag);
        orderOut.setWarehouse(warehouse);
        return ResponseEntity.ok(orderOutService.listByCondition(orderOut,pageNum,pageSize));
    }

    @PostMapping
    public void insert(@RequestBody OrderOut orderOut) {
        orderOutService.insert(orderOut);
    }

    @PutMapping
    public void  update(@RequestBody OrderOut orderOut){
        orderOutService.update(orderOut);
    }

    @DeleteMapping
    public void  delete(@RequestParam( "order_no" ) String order_no){
        OrderOut orderOut = new OrderOut();
        orderOut.setOrder_no(order_no);
        orderOutService.delete(orderOut);
    }
}
