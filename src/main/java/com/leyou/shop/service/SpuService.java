package com.leyou.shop.service;

import com.leyou.shop.dao.SpuDao;
import com.leyou.shop.model.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {

    @Autowired
    private SpuDao spuDao;

    public List<Spu> list(Spu spu){
        return spuDao.select(spu);
    }

    public List<Spu> queryByParentId(Long parentid){
        return spuDao.queryByParentId(parentid);
    }
}
