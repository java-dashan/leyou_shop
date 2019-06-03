package com.leyou.shop.service;

import com.leyou.shop.dao.SkusDao;
import com.leyou.shop.model.Skus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkuService {

    @Autowired
    private SkusDao skusDao;

    public List<Skus> skusListByspuId(Skus skus){
        return skusDao.select(skus);
    }

    public Skus query(Skus skus){
        return skusDao.selectOne(skus);
    }



}
