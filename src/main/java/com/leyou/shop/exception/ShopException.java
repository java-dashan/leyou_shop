package com.leyou.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopException extends  RuntimeException{
    private int code;
    private String msg;
}
