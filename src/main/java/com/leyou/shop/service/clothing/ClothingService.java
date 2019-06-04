package com.leyou.shop.service.clothing;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.clothing.ClothingDao;
import com.leyou.shop.model.clothing.Clothing;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ClothingService {

    @Autowired
    private ClothingDao clothingDao;

    public PageResult<Clothing> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Clothing> page = (Page<Clothing>) clothingDao.selectAll();
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }

    public PageResult<Clothing> listByCondition(Clothing clothing, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Clothing> page = (Page<Clothing>) clothingDao.select(clothing);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(Clothing clothing) {
         clothingDao.insertSelective(clothing);
    }

    public void update(Clothing clothing) {
        clothingDao.updateByPrimaryKeySelective(clothing);
    }

    public void delete(Clothing clothing) {
        clothingDao.deleteByPrimaryKey(clothing);
    }
}
