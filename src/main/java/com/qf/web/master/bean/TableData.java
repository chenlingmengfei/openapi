package com.qf.web.master.bean;

import lombok.Data;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
@Data
public class TableData<T> {

    private Integer code = 0;

    private String msg;

    private Long count;

    private List<T> data;

}
