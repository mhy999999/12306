package com.example.tickets.controller;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.pojo.vo.OrderInfoVO;
import com.example.tickets.service.OrderService;
import com.example.tickets.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询用户订单
     * @param userId
     * @return
     */
    @CrossOrigin(origins = "")
    @GetMapping("/order")
    public Result getOrderByUerId(@RequestParam Integer userId){

        List<OrderInfoVO> list = orderService.getOrderByUerId(userId);
        log.info("查询订单信息:{}",list);

        return Result.success(list);
    }



}
