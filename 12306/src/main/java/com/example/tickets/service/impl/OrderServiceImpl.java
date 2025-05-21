package com.example.tickets.service.impl;

import com.example.tickets.mapper.OrderMapper;
import com.example.tickets.mapper.TicketMapper;
import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.pojo.vo.OrderInfoVO;
import com.example.tickets.service.OrderService;
import com.example.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<OrderInfoVO> getOrderByUerId(Integer userId) {
        return orderMapper.getOrderByUerId(userId);
    }
}
