package com.qf.web.master.pojo;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {

  private Integer id;
  private String name;
  private Integer parentId;
  private String url;
  private String icon;
  private String perms;
  private Integer type;
  private Integer sort;

  List<Menu> children = new ArrayList<>();

}
