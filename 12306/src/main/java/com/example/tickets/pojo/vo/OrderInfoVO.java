package com.example.tickets.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoVO {
    private long orderId;
    private String orderNo;
    private long userId;
    private double totalPrice;
    private String status;
    private LocalDate createdAt;
    private String trainNumber;
    private String departureStation;
    private String arrivalStation;
    private LocalDate scheduleDate;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String duration;
    private Long businessAvailable;
    private Long firstAvailable;
    private Long secondAvailable;
}
