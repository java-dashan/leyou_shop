package com.leyou.shop.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    private Integer id;

    private String username;

    private Integer phone;

    private String password;

    private Date created;
}
