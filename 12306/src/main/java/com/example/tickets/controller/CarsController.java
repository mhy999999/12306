package com.example.tickets.controller;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;
import com.example.tickets.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class CarsController {
    @Autowired
    private CarService carService;

    /**
     * 添加车次
     * @param trains
     * @return 响应描述
     * 对于`@RequestBody`将使用`application/json`
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/Cars/Add")
    public Result add(@RequestBody Trains trains) {
        Result result = carService.add(trains);
        return result;
    }

    /**
     * 查询所有车次
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/Cars/SelectAll")
    public Result selectAll() {
        Result result = carService.selectAll();
        return result;
    }

    /**
     * 根据日期和出发站和终点站查询车次
     * @param trains
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/Cars/SelectCarsByDateAndStartEndpoint")
    public Result selectCarsByDateAndStartEndpoint(@RequestBody Trains trains) {
        // 安全处理null值，优先获取departureTime是否为null
        LocalTime startTime = trains.getDepartureTime() != null 
            ? LocalTime.from(trains.getDepartureTime()) 
            : null;
        LocalDate dateTime = trains.getScheduleDate();
        long startStationId = trains.getDepartureStationId();
        long endStationId = trains.getArrivalStationId();
        
        // 重构时间判断逻辑，分三种情况处理
        if (startTime == null) {
            startTime = dateTime.isEqual(LocalDate.now()) 
                ? LocalTime.now()  // 当天用当前时间
                : LocalTime.MIN;   // 非当天用最小时间
        }
        
        Result result = carService.selectCarsByDateAndStartEndpoint(dateTime,  startTime, startStationId, endStationId);
        return result;
    }


    /**
     * 查询所有站点
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/Cars/SelectaAllStations")
    public Result selectaAllStations() {
        Result result = carService.selectAllStations();
        return result;
    }

}
