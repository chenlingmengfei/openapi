package com.qf.web.master.pojo;

import lombok.Data;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
@Data
public class Customer {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String address;

    private Integer money;

    private Integer state;

}
