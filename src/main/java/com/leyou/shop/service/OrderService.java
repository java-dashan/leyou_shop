package com.leyou.shop.service;

import com.leyou.shop.dao.OrderDao;
import com.leyou.shop.dao.SaleRankListDao;
import com.leyou.shop.model.Order;
import com.leyou.shop.model.SaleRankList;
import com.leyou.shop.util.IdWorker;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private IdWorker idWorker;


    public PageResult<Order> query() {


        return new PageResult<>();
    }


    public void insert(Order order) {
        order.setOrder_id(idWorker.nextId());
        orderDao.insert(order);
    }

    public void update(Order order) {
        orderDao.updateByPrimaryKeySelective(order);
    }

    public void delete(Long id) {
        orderDao.deleteByPrimaryKey(id);
    }
}
