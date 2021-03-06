package com.leyou.shop.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leyou.shop.util.JsonLongSerializer;
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
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;

    private String username;

    private String phone;

    private String password;

    private Date created;

    private String u_name;

    private String introduction;
}
