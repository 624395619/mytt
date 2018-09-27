package com.qf.mytt.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbContentCategory extends BaseTreeEntity implements Serializable{

    //父分类
    private TbContentCategory parentCategory;

    private String name;
    private String address;
    private int status;
    private int sortOrder;

}
