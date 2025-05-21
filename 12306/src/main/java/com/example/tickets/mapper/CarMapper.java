package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Trains;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    void add(Trains trains);

    List<Trains> selectAll();
}
