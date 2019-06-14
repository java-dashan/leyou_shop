package com.leyou.shop.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leyou.shop.util.JsonLongSerializer;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_sale_ranklist")
@Data
public class SaleRankList {
    @Id
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long spu_id;
    private String title;
    private Integer count;
    private Date create_time;
    private Date update_time;
}
