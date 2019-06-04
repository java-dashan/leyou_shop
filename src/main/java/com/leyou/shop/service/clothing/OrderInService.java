package com.leyou.shop.service.clothing;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.clothing.OrderInDao;
import com.leyou.shop.model.clothing.OrderIn;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInService {
    @Autowired
    private OrderInDao orderInDao;

    public PageResult<OrderIn> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderIn> page = (Page<OrderIn>) orderInDao.selectAll();
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }

    public PageResult<OrderIn> listByCondition(OrderIn OrderIn, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderIn> page = (Page<OrderIn>) orderInDao.select(OrderIn);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(OrderIn orderIn) {
        orderInDao.insertSelective(orderIn);
    }

    public void update(OrderIn orderIn) {
        orderInDao.updateByPrimaryKeySelective(orderIn);
    }

    public void delete(OrderIn orderIn) {
        orderInDao.deleteByPrimaryKey(orderIn);
    }
}
