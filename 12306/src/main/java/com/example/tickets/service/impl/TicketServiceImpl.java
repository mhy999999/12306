package com.example.tickets.service.impl;

import com.example.tickets.mapper.TicketMapper;
import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @Override
    public List<Tickets> getTicketByName(String realName) {
        return ticketMapper.getTicketByName(realName);
    }

    @Override
    public List<Tickets> buyTicket(ButTicketDTO butTicketDTO) {
        //1.校验身份证
        if (!butTicketDTO.getPassengerId().matches("\\d{18}")) {
           throw new RuntimeException("身份证格式错误");
        }
        //2.生成订单

        //生成随机订单号
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(20);

        for (int i = 0; i < 20; i++) {
            int index = secureRandom.nextInt(CHAR_SET.length());
            sb.append(CHAR_SET.charAt(index));
        }

        String orderNo = sb.toString();
//        System.out.println(orderNo);

        Orders orders = Orders.builder()
                .orderNo(orderNo)
                .userId(butTicketDTO.getUserId())
                .dateId(butTicketDTO.getDateId())
                .totalPrice(butTicketDTO.getPrice())
                .status("unpaid")
                .build();

        System.out.println(orders);
        ticketMapper.addOrder(orders);

        Integer orderId = orders.getId();
        System.out.println("订单id为：" + orderId);
        //3.扣减当前车次座位数量

        //4.分配车厢和座位

        //5.保存订单和座位信息并返回票务信息


        return List.of();
    }
}
