package com.qf.mytt.admin.service.impl;

import com.qf.mytt.admin.dao.BaseTreeDao;
import com.qf.mytt.admin.service.BaseTreeService;
import com.qf.mytt.domain.BaseTreeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BaseTreeServiceImpl<T extends BaseTreeEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    @Override
    public List<T> selectAll(T t) {
        return dao.selectAll(t);
    }

    @Override
    public List<T> selectByPid(long parentId) {
        return dao.selectByPid(parentId);
    }

    @Override
    public void save(T t) {
        // 设置更新时间
        t.setUpdated(new Date());

        // ID 为 0 是表示新增
        if (t.getId() == 0) {
            t.setCreated(new Date());
            dao.insert(t);
        }

        // 更新数据
        else {
            dao.update(t);
        }
    }

    @Override
    public T get(long id) {
        return dao.get(id);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public int countByPid(long pid) {
        return dao.countByPid(pid);
    }
}
