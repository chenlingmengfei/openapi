package com.qf.web.master.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Recharge {

  private Integer id;
  private Integer cusId;
  private Long orderId;
  @JsonFormat(pattern = "yyyy-MM-hh HH:mm:ss",timezone = "GMT+8")
  private Date createtime;
  @JsonFormat(pattern = "yyyy-MM-hh HH:mm:ss",timezone = "GMT+8")
  private Date updatetime;
  private Integer money;
  private Integer state;
  private Integer paymenttype;

}
