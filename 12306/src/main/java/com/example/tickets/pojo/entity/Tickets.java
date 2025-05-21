package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tickets {

  private long id;
  private long seatId;
  private long orderId;
  private String passengerName;
  private String passengerId;
  private String seatType;
  private String seatNumber;
  private String carriageNumber;
  private double price;

}
