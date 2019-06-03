package com.leyou.shop.dao;

import com.leyou.shop.model.Spu;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuDao extends Mapper<Spu> {

    @Select("select * from tb_spu where cid1=#{parentid} or cid3=#{parentid} or cid2=#{parentid}")
    List<Spu> queryByParentId(Long parentid);
}
