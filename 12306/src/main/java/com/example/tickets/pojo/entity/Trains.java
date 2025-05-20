package com.example.tickets.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trains {
  private long id;
  private String trainNumber;
  private long departureStationId;
  private long arrivalStationId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime departureTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime arrivalTime;
  private String duration;
  private long businessSeats;
  private long firstSeats;
  private long secondSeats;
  }