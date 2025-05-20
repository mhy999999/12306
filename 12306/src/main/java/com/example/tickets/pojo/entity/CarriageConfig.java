package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarriageConfig {

  private long id;
  private String trainType;
  private String seatType;
  private long rows;
  private long cols;

}
