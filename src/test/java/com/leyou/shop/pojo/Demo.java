package com.leyou.shop.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo implements Serializable {
    private String value;
    public Demo(String a){
        this.value=a;
    }
}
