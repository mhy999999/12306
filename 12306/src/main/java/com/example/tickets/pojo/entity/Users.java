package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
  private long id;
  private String username;
  private String password;
  private String realName;
  private String idCard;
  private String phone;
  private String userType;
  private LocalTime createTime;
}
