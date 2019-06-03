package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    private Long id;
    private String title;
    private String sub_title;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brand_id;
    private Boolean saleable;
    private Boolean valid;
    private Date create_time;
    private Date last_update_time;
}
