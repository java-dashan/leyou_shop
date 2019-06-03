package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_order_detail")
public class OrderDetail {
    @Id
    private Long id;
    private Long order_id;
    private Long sku_id;
    private Integer num;
    private String title;
    private String own_spec;
    private Long price;
    private String image;
}
