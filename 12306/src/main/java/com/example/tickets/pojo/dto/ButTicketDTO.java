package com.example.tickets.pojo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ButTicketDTO {
    private long dateId;
    private double price;
    private Integer userId;
    private String passengerName;
    private String passengerId;
    private String seatType;



}
