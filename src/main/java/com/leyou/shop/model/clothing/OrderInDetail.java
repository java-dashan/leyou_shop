package com.leyou.shop.model.clothing;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "order_in_detail")
public class OrderInDetail {
    private String order_no;
    private String code;
    private String color;
    private String size;
    private Integer count;
    @Id
    private Long id;
}
