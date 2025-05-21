package com.example.tickets.service;


import com.example.tickets.pojo.dto.ButTicketDTO;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.pojo.vo.OrderInfoVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface OrderService {

    List<OrderInfoVO> getOrderByUerId(Integer userId);
}
