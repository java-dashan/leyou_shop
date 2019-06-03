package com.leyou.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_user")
public class User {
    @Id
    private Long id;

    private String username;

    private String phone;

    private String password;

    private Date created;
}
