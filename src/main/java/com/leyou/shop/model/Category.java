package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_category")
public class Category {
    @Id
    private Long id;

    private Long parent_id;

    private Boolean is_parent;

    private String name;

    private Integer sort;   //排序指数
}
