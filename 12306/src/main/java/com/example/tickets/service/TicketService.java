package com.example.tickets.service;


import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Tickets;

import java.util.List;

public interface TicketService {
    /**
     * 根据用户名获取用户所有订单
     * @param realName
     * @return
     */
    List<Tickets> getTicketByName(String realName);

    /**
     * 购买车票
     * @param butTicketDTO
     * @return
     */
    List<Tickets> buyTicket(ButTicketDTO butTicketDTO);
}
