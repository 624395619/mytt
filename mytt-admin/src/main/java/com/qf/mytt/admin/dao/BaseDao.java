package com.qf.mytt.admin.dao;


import java.util.List;

public interface BaseDao<T> {
    List<T> selectAll();

    List<T> selectPageList(T t);

    void insert(T t);

    int getTotalCount(T t);

    T findById(long id);

    T getById(long id);

    void update(T t);

    void delete(long id);

    void deleteAll(long[] ids);
}
