package com.leyou.shop.service.clothing;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.clothing.OrderOutDetailDao;
import com.leyou.shop.model.clothing.OrderOutDetail;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderOutDetailService {
    @Autowired
    private OrderOutDetailDao orderOutDetailDao;

    public PageResult<OrderOutDetail> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderOutDetail> page = (Page<OrderOutDetail>) orderOutDetailDao.selectAll();
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }

    public PageResult<OrderOutDetail> listByCondition(OrderOutDetail clothing, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderOutDetail> page = (Page<OrderOutDetail>) orderOutDetailDao.select(clothing);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(OrderOutDetail orderOutDetail) {
        orderOutDetailDao.insertSelective(orderOutDetail);
    }

    public void update(OrderOutDetail orderOutDetail) {
        orderOutDetailDao.updateByPrimaryKeySelective(orderOutDetail);
    }

    public void delete(OrderOutDetail orderOutDetail) {
        orderOutDetailDao.deleteByPrimaryKey(orderOutDetail);
    }
}
