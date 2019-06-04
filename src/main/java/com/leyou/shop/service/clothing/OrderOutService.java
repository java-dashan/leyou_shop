package com.leyou.shop.service.clothing;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.clothing.OrderOutDao;
import com.leyou.shop.model.clothing.OrderOut;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderOutService {
    @Autowired
    private OrderOutDao orderOutDao;

    public PageResult<OrderOut> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderOut> page = (Page<OrderOut>) orderOutDao.selectAll();
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }

    public PageResult<OrderOut> listByCondition(OrderOut clothing, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderOut> page = (Page<OrderOut>) orderOutDao.select(clothing);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(OrderOut orderOut) {
        orderOutDao.insertSelective(orderOut);
    }

    public void update(OrderOut orderOut) {
        orderOutDao.updateByPrimaryKeySelective(orderOut);
    }

    public void delete(OrderOut orderOut) {
        orderOutDao.deleteByPrimaryKey(orderOut);
    }
}
