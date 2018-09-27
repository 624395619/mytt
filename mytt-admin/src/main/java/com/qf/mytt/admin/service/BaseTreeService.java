package com.qf.mytt.admin.service;

import com.qf.mytt.domain.BaseTreeEntity;

import java.util.List;

public interface BaseTreeService<T extends BaseTreeEntity> {
    List<T> selectAll(T t);

    List<T> selectByPid(long parentId);

    void save(T t);

    T get(long id);

    void delete(long id);

    /**
     * 根据父类目 ID 查询子类目笔数
     * @param pid
     * @return
     */
    int countByPid(long pid);
}
