package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Stations;
import com.example.tickets.pojo.entity.Trains;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Mapper
public interface CarMapper {
    void add(Trains trains);

    List<Trains> selectAll();

    List<Trains> selectCarsByDateAndStartEndpoint(LocalDate dateTime, LocalTime startTime, long startStationId, long endStationId);

    void addTrainDate(Trains trains);

    List<Stations> selectAllStations();
}
