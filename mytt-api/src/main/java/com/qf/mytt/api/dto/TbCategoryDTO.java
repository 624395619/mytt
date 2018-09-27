package com.qf.mytt.api.dto;

import com.qf.mytt.domain.TbContentCategory;

import java.util.Date;

public class TbCategoryDTO {
    private long id;

    //父分类
    private TbContentCategory parentCategory;

    private String name;
    private String address;
    private int status;
    private int sortOrder;

    private Date updated;
    private Date created;
}
