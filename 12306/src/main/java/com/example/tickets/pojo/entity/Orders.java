package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  private Integer id;
  private String orderNo;
  private long userId;
  private long dateId;
  private double totalPrice;
  private String status;
  private LocalDate createdAt;

}
