package com.example.tickets.service.impl;

import com.example.tickets.mapper.TicketMapper;
import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        //2.扣减当前车次座位数量
        try {
            if (butTicketDTO.getSeatType().equals("second")){
                ticketMapper.reduceSeatNum(butTicketDTO.getDateId());
            } else if (butTicketDTO.getSeatType().equals("first")) {
                ticketMapper.reduceSeatNum(butTicketDTO.getDateId());
            }else {
                ticketMapper.reduceSeatNum(butTicketDTO.getDateId());
            }
        }catch (Exception e){
            throw new RuntimeException("座位不足");
        }


        //3.生成订单

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
                .status("paid")
                .build();

        System.out.println(orders);
        ticketMapper.addOrder(orders);

        Integer orderId = orders.getId();
        System.out.println("订单id为：" + orderId);

        //4.分配车厢和座位
        Random random = new Random();
        String seatLetters = "ABCDE"; // 可选字母
        String carriageNumber = "";
        String seatNumber = "";

        int temp1 = random.nextInt(16) + 1; // 1~16
        if (temp1 < 10){
            carriageNumber = "0" + temp1;
        }else {
            carriageNumber = "" + temp1;
        }
        System.out.println(carriageNumber);

        int temp2 = random.nextInt(16) + 1; // 1~16
        char seatLetter = seatLetters.charAt(random.nextInt(5)); // A~E
        if (temp2 < 10){
            seatNumber = "0" + temp2 + seatLetter;
        }else {
            seatNumber = "" + temp2 + seatLetter;
        }
        System.out.println(seatNumber);


        //5.保存订单和座位信息并返回票务信息
        Tickets tickets = Tickets.builder()
                .seatId(1)
                .orderId(orderId)
                .passengerName(butTicketDTO.getPassengerName())
                .passengerId(butTicketDTO.getPassengerId())
                .seatType(butTicketDTO.getSeatType())
                .seatNumber(seatNumber)
                .carriageNumber(carriageNumber)
                .price(butTicketDTO.getPrice())
                .build();
        System.out.println(tickets);

        ticketMapper.addTicket(tickets);
        List<Tickets> ticketsList = new ArrayList<>();
        ticketsList.add(tickets);

        return ticketsList;
    }
}
