package com.leyou.shop.dao;

import com.leyou.shop.model.Spu;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuDao extends Mapper<Spu> {

    @Select("select * from tb_spu where cid1=#{parentid} or cid3=#{parentid} or cid2=#{parentid}") //and saleable = 1
    List<Spu> queryByParentId(Long parentid);

    @Select(("select * from tb_spu where brand_id in(select id from tb_brand where name like #{name})"))
    List<Spu> queryByBrandName(String name);
}
