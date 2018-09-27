package com.qf.mytt.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity  implements Serializable {
    private long id;
    private int start;
    private int length;

    private Date created;
    private Date updated;
}
