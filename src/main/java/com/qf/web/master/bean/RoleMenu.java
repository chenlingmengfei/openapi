package com.qf.web.master.bean;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/4
 */
@Data
public class RoleMenu {

    Integer roleId;

    List<Integer> menuIds;

}
