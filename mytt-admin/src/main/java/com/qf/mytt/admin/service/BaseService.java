package com.qf.mytt.admin.service;



import java.util.List;

public interface BaseService<T> {
    List<T> selectAll();
    List<T> selectPageList(T t);
    void delete(long id);
    void deleteAll(long[] ids);
    void update(T t);
    void insert(T t);
    T findById(long id);
    int getTotalCount(T t);
    void save(T t);
    T getById(long id);
}
