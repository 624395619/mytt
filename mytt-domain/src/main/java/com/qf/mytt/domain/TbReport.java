package com.qf.mytt.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = true)
public class TbReport extends BaseEntity implements Serializable{


    private  TbUser reporter;

    private  TbUser toReporter;

    private TbComment tbComment;

    private String reportContent;

    private int isDeal;
}
