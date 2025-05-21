package com.example.tickets.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Changes {

  private long id;
  private long originalOrderId;
  private long newOrderId;
  private long ticketId;
  private double changeFee;
  private String status;
  private Timestamp createdAt;
}
