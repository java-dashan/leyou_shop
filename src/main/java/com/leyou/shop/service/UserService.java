package com.leyou.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.shop.dao.UserDao;
import com.leyou.shop.exception.ShopException;
import com.leyou.shop.model.User;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User query(User user){
        return userDao.selectOne(user);
    }

    public void save(User user){
        try {
            userDao.insert(user);
        }catch (Exception e){
            throw new ShopException(200,e.getMessage());
        }
    }

    public void update(User user){
        userDao.updateByPrimaryKeySelective(user);
    }

    public void delete(User user){
        userDao.deleteByPrimaryKey(user);
    }

    public PageResult<User> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> pageInfo = (Page<User>) userDao.selectAll();
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getResult());
    }

    public PageResult<User> listByName(int pageNum, int pageSize, String name) {
        User user = new User();
        user.setU_name(name);
        PageHelper.startPage(pageNum, pageSize);
        Page<User> pageInfo = (Page<User>) userDao.select(user);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getResult());
    }
}
