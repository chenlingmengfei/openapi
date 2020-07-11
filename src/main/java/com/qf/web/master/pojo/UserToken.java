package com.qf.web.master.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserToken {

  private Integer id;
  private Integer appId;
  private Integer userId;
  private String accessToken;
  @DateTimeFormat(pattern = "yyyy-MM-hh HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-hh HH:mm:ss",timezone = "GMT+8")
  private Date expireTime;
  @DateTimeFormat(pattern = "yyyy-MM-hh HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-hh HH:mm:ss",timezone = "GMT+8")
  private Date startTime;
}
