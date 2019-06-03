package com.leyou.shop.controller.req;

import lombok.Data;

@Data
public class UserReq{
    private Boolean isremeber;
    private String username;
    private String password;
}
