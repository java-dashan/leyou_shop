package com.leyou.shop.service;

import com.leyou.shop.controller.res.Goods;
import com.leyou.shop.dao.SkusDao;
import com.leyou.shop.dao.SpuDao;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private SpuDao spuDao;
    @Autowired
    private SkusDao skusDao;

//    private PageResult<Goods> list(){
//
//    }

}
