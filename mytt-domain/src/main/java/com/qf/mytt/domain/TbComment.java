package com.qf.mytt.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = true)
public class TbComment extends BaseEntity implements Serializable{

    private TbUser tbUser;

    private TbContent tbContent;

    private int status;
    private String comContent;
    private int praiseNum;
}
