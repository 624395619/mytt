package com.qf.mytt.api.service.Impl;

import com.qf.mytt.api.dao.CategoryDao;
import com.qf.mytt.api.service.CategoryService;
import com.qf.mytt.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public TbContentCategory getByAddress(TbContentCategory tbContentCategory) {
        return categoryDao.getByAddress(tbContentCategory);
    }
}
