package com.example.tickets.service.impl;

import com.example.tickets.mapper.CarMapper;
import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;
import com.example.tickets.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public Result add(Trains trains) {
        LocalDateTime departureTime = trains.getDepartureTime();
        LocalDateTime arrivalTime = trains.getArrivalTime();

        Duration duration = Duration.between(departureTime, arrivalTime);
        long totalHours = duration.toHours();      // 自动包含天数转换的小时数
        int minutes = duration.toMinutesPart();    // 扣除整小时后的剩余分钟

        // 统一格式化为 "几时几分"（如：26时30分、0时45分）
        String durationStr = String.format("%d时%d分", totalHours, minutes);
        trains.setDuration(durationStr);

        carMapper.add(trains);
        return Result.success(trains);
    }

    @Override
    public Result selectAll() {
        List<Trains> trains = carMapper.selectAll();
        return Result.success(trains);
    }

}