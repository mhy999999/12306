package com.example.tickets.service;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;

public interface CarService {
    Result add(Trains trains);

    Result selectAll();
}
