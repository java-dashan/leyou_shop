package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_sku")
public class Skus {   //库存单元     spu标准化产品单元

    @Column(name = "id")
    @Id
    private Integer skuid;

    @Column(name = "spu_id")
    private Integer spuid;

    private String title;

    private String images;

    private Integer price;

    private String indexes;

    private String own_spec;

    private Integer enable;

    private Date create_time;

    private Date last_update_time;
}
