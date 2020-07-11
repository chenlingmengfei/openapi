package com.qf.web.master.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResponse {

    private boolean state;

    private String message;

    private Object data;

}
