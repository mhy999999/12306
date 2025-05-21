package com.example.tickets.service;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface CarService {
    Result add(Trains trains);

    Result selectAll();

    Result selectCarsByDateAndStartEndpoint(LocalDate dateTime, LocalTime startTime, long startStationId, long endStationId);
}
