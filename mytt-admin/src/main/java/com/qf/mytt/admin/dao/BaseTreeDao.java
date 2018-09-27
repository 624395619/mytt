package com.qf.mytt.admin.dao;

import com.qf.mytt.domain.BaseTreeEntity;

import java.util.List;

/**
 * 树形结构通用数据访问接口
 */
public interface BaseTreeDao<T extends BaseTreeEntity> {
    List<T> selectAll(T t);

    List<T> selectByPid(long parentId);

    void insert(T t);

    void update(T t);

    T get(long id);

    void delete(long id);

    int countByPid(long pid);
}
