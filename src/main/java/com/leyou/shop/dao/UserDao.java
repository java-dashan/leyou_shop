package com.leyou.shop.dao;

import com.leyou.shop.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDao extends Mapper<User> {
    @Select("select * from tb_user where u_name like #{u_name}")
    public List<User> listByname(String u_name);
}
