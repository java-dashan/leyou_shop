package com.leyou.shop.service;

import com.leyou.shop.dao.UserDao;
import com.leyou.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private User query(User user){
        return userDao.selectOne(user);
    }

    private void save(User user){
        userDao.insert(user);
    }

    private void update(User user){
        userDao.updateByPrimaryKeySelective(user);
    }

    private void delete(User user){
        userDao.deleteByPrimaryKey(user);
    }
}
