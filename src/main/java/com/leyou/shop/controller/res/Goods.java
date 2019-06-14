package com.leyou.shop.controller.res;

import com.leyou.shop.model.Skus;
import lombok.Data;

import java.util.List;

@Data
public class Goods {
    private Long spu_id;
    private String title;
    private String sub_title;  //子标题
    private Long brand_id;     //品牌id
    List<Skus> list;
}
