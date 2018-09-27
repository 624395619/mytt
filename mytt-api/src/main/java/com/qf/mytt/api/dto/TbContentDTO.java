package com.qf.mytt.api.dto;


import com.qf.mytt.domain.TbUser;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;
@Data
public class TbContentDTO implements Serializable{
    private long id;

    private TbUser tbUser;

    private String username;

    private long userId;

    private long tbContentCategoryId;

    private String tbContentCategoryName;

    private String title;

    private String content;
    private String url;
    private String coverPic;
    private String tagInfo;
    private Date updated;
    private Date created;

}
