package com.leyou.shop.util;


public enum ShopExceptionEnum {

    NOT_FOUND_SKU(404,"未找到商品"),






    NOT_FOUND_SPU(404,"未找到spu");


    private int status;
    private String msg;

    ShopExceptionEnum(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}