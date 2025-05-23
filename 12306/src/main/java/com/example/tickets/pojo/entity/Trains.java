package com.example.tickets.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trains extends TrainsName {
    private long id;
    private String trainNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long departureStationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long arrivalStationId;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime arrivalTime;
    private String duration;
    private Long businessSeats;
    private Long firstSeats;
    private Long secondSeats;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class TrainsName extends TrainDate {
    private String departureStationName;
    private String departureStationCity;
    private String arrivalStationName;
    private String arrivalStationCity;
}
