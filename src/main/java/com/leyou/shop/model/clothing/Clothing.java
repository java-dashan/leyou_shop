package com.leyou.shop.model.clothing;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "clothing")
public class Clothing {
    @Id
    private String code;
    @Id
    private String color;
    @Id
    private String size;
    private String name;
    private String m_out;
    private String m_in;
    private Double out_price;
    private Double slae_price;
    private Boolean flag;
}
