package com.leyou.shop.intercept;

import com.leyou.shop.exception.ShopException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionIntercept {

    @ResponseBody
    @ExceptionHandler(value = ShopException.class)
    public ResponseEntity<ShopException> errorHandler(ShopException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex);
    }

}
