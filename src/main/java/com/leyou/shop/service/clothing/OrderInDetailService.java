package com.leyou.shop.service.clothing;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.clothing.OrderInDetailDao;
import com.leyou.shop.model.clothing.OrderInDetail;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInDetailService {
    @Autowired
    private OrderInDetailDao orderInDetailDao;

    public PageResult<OrderInDetail> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderInDetail> page = (Page<OrderInDetail>) orderInDetailDao.selectAll();
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }

    public PageResult<OrderInDetail> listByCondition(OrderInDetail orderInDetailDetail, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderInDetail> page = (Page<OrderInDetail>) orderInDetailDao.select(orderInDetailDetail);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(OrderInDetail orderInDetail) {
        orderInDetailDao.insertSelective(orderInDetail);
    }

    public void update(OrderInDetail orderInDetail) {
        orderInDetailDao.updateByPrimaryKeySelective(orderInDetail);
    }

    public void delete(OrderInDetail orderInDetail) {
        orderInDetailDao.deleteByPrimaryKey(orderInDetail);
    }

}
