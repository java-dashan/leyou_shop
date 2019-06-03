package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_collection")
public class UserCollection {
    @Id
    private Long id;
    private Long sku_id;
    private Long user_id;
    private Date create_time;
}
