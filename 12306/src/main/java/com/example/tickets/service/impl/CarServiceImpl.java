package com.example.tickets.service.impl;

import com.example.tickets.mapper.CarMapper;
import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;
import com.example.tickets.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public Result add(Trains trains) {
        // 合并日期和时间
        LocalDateTime departureDateTime = trains.getScheduleDate().atTime(trains.getDepartureTime());
        LocalDateTime arrivalDateTime = trains.getScheduleDate().atTime(trains.getArrivalTime());

        Duration duration = Duration.between(departureDateTime, arrivalDateTime);
        long totalHours = duration.toHours();      // 自动包含天数转换的小时数
        int minutes = duration.toMinutesPart();    // 扣除整小时后的剩余分钟

        String durationStr = String.format("%d时%d分", totalHours, minutes);
        trains.setDuration(durationStr);

        carMapper.add(trains);

        trains.setBusinessAvailable(trains.getBusinessSeats());
        trains.setFirstAvailable(trains.getFirstSeats());
        trains.setSecondAvailable(trains.getSecondSeats());
        carMapper.addTrainDate(trains);
        return Result.success(trains);
    }

    @Override
    public Result selectAll() {
        List<Trains> trains = carMapper.selectAll();
        return Result.success(trains);
    }

    @Override
    public Result selectCarsByDateAndStartEndpoint(LocalDate dateTime, LocalTime startTime, long startStationId, long endStationId) {
        List<Trains> trains = carMapper.selectCarsByDateAndStartEndpoint(dateTime,  startTime, startStationId, endStationId);
        return Result.success(trains);
    }

}