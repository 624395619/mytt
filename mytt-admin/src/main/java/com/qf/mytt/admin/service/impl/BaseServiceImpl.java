package com.qf.mytt.admin.service.impl;


import com.qf.mytt.admin.dao.BaseDao;
import com.qf.mytt.admin.service.BaseService;
import com.qf.mytt.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    private D dao;


    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<T> selectPageList(T t) {
        return dao.selectPageList(t);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAll(long[] ids) {
        dao.deleteAll(ids);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(T t) {
        dao.update(t);
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(T t) {
        dao.insert(t);
    }

    @Override
    public T findById(long id) {
        return dao.findById(id);
    }


    @Override
    public int getTotalCount(T t) {
        return dao.getTotalCount(t);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(T t) {
        if(t.getId()==0){
            t.setCreated(new Date());
            t.setUpdated(new Date());
            insert(t);
        }

        else{
            t.setUpdated(new Date());
            update(t);
        }
    }


    @Override
    public T getById(long id) {
        return dao.getById(id);
    }
}
