package com.leyou.shop.service;

import com.leyou.shop.dao.CategoryDao;
import com.leyou.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> list(Category category){
        return categoryDao.select(category);
    }

}
