package com.leyou.shop.service;

import com.leyou.shop.dao.UserDao;
import com.leyou.shop.exception.ShopException;
import com.leyou.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
