package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Refunds {

  private long id;
  private long orderId;
  private long ticketId;
  private double refundAmount;
  private String refundReason;
  private String status;
  private LocalDate createdAt;

}