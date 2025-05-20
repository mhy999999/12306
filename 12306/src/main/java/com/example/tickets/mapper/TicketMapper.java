package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketMapper {

    @Select("select * from tickets where passenger_name = #{realname}")
    List<Tickets> getTicketByName(String realname);


    void addOrder(Orders orders);
}
