package com.example.tickets.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trains {

  private long id;
  private String trainNumber;
  private long departureStationId;
  private long arrivalStationId;
  private java.sql.Time departureTime;
  private java.sql.Time arrivalTime;
  private long duration;
  private long businessSeats;
  private long firstSeats;
  private long secondSeats;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTrainNumber() {
    return trainNumber;
  }

  public void setTrainNumber(String trainNumber) {
    this.trainNumber = trainNumber;
  }


  public long getDepartureStationId() {
    return departureStationId;
  }

  public void setDepartureStationId(long departureStationId) {
    this.departureStationId = departureStationId;
  }


  public long getArrivalStationId() {
    return arrivalStationId;
  }

  public void setArrivalStationId(long arrivalStationId) {
    this.arrivalStationId = arrivalStationId;
  }


  public java.sql.Time getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(java.sql.Time departureTime) {
    this.departureTime = departureTime;
  }


  public java.sql.Time getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(java.sql.Time arrivalTime) {
    this.arrivalTime = arrivalTime;
  }


  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public long getBusinessSeats() {
    return businessSeats;
  }

  public void setBusinessSeats(long businessSeats) {
    this.businessSeats = businessSeats;
  }


  public long getFirstSeats() {
    return firstSeats;
  }

  public void setFirstSeats(long firstSeats) {
    this.firstSeats = firstSeats;
  }


  public long getSecondSeats() {
    return secondSeats;
  }

  public void setSecondSeats(long secondSeats) {
    this.secondSeats = secondSeats;
  }

}
