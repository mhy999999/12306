package com.example.tickets.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDate {

  private long id;
  private long trainId;
@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate scheduleDate;
  private long businessAvailable;
  private long firstAvailable;
  private long secondAvailable;

}
