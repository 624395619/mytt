package com.qf.mytt.api.dao;

import com.qf.mytt.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao {
    TbContentCategory getByAddress(TbContentCategory tbContentCategory);
}
