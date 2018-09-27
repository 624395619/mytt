package com.qf.mytt.admin.web.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataTablesResult<T> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
}
