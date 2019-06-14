package com.leyou.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.shop.dao.SpuDao;
import com.leyou.shop.model.Spu;
import com.leyou.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SpuService {

    @Autowired
    private SpuDao spuDao;

    public PageResult<Spu> list(Spu spu, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("saleable",1);    //上架中
        Page<Spu> pageInfo = (Page<Spu>) spuDao.selectByExample(example);
        List<Spu> spus = pageInfo.getResult();
//        System.out.println(pageInfo.getPageNum());  当前页
//        System.out.println(pageInfo.getPages());    总页数
//        System.out.println(pageInfo.getPageSize());  每页个数
        return new PageResult<Spu>(pageInfo.getTotal(), pageInfo.getPages(), spus);
    }

    public PageResult<Spu> queryByParentId(Long parentid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Spu> pageInfo = (Page<Spu>) spuDao.queryByParentId(parentid);
        List<Spu> spus = pageInfo.getResult();
        return new PageResult<Spu>(pageInfo.getTotal(), pageInfo.getPages(), spus);
    }

    public PageResult<Spu> listLikeByTitle(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("title", "%" + name + "%");
        Page<Spu> pageInfo = (Page<Spu>) spuDao.selectByExample(example);
        List<Spu> spus = pageInfo.getResult();
        System.out.println(pageInfo.getResult().stream().map(spu -> spu.getTitle()).collect(Collectors.toList()));
//        System.out.println(pageInfo.getPageNum());  当前页
//        System.out.println(pageInfo.getPages());    总页数
//        System.out.println(pageInfo.getPageSize());  每页个数
        return new PageResult<Spu>(pageInfo.getTotal(), pageInfo.getPages(), spus);
    }

    public PageResult<Spu> queryByBrandName(String name, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<Spu> page = (Page<Spu>) spuDao.queryByBrandName("%"+name+"%");
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }


    public void insert(Spu spu) {
        spuDao.insertSelective(spu);
    }

    public void delete(Long id) {
        spuDao.deleteByPrimaryKey(id);
    }

    public void update(Spu spu) {
        spuDao.updateByPrimaryKeySelective(spu);
    }

    public PageResult<Spu> queryByCreateTime(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Spu.class);
//        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        Page<Spu> page= ( Page<Spu>) spuDao.selectByExample(example);
        return new PageResult<>(page.getTotal(), page.getPages(), page.getResult());
    }
}
