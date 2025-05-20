package com.example.tickets.controller;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Trains;
import com.example.tickets.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/Cars/Add")
    public Result add(@RequestBody Trains trains) {

        Result result = carService.add(trains);
        return result;
    }

    /**
     * 查询所有车次
     * @return
     */
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/Cars/SelectAll")
    public Result selectAll() {
        Result result = carService.selectAll();
        return result;
    }
}