package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seats {

  private long id;
  private long trainId;
  private String carriageNumber;
  private String seatNumber;
  private String seatType;
  private long rowNum;
  private long colNum;
  private long positionX;
  private long positionY;

}
