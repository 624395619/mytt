package com.qf.mytt.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbContent extends BaseEntity implements Serializable{

    private TbUser tbUser;
    private TbContentCategory tbContentCategory;
    @Length(min = 1,max = 50,message = "标题长度必须在1到50位之间")
    private String title;
    @Length(min = 1,max = 200,message = "标题描述长度必须在1到200位之间")
    private String content;
    private String url;
    private String coverPic;
    private String tagInfo;
}
