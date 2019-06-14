package com.leyou.shop.exception;

import com.leyou.shop.util.ShopExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopException extends  RuntimeException{
    private int status;
    private String msg;

    public ShopException(ShopExceptionEnum exceptionEnum) {
        this.status=exceptionEnum.getStatus();
        this.msg = exceptionEnum.getMsg();
    }
}
