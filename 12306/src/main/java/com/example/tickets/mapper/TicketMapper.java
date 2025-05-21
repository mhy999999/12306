package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketMapper {

    @Select("select * from tickets where passenger_name = #{realname}")
    List<Tickets> getTicketByName(String realname);


    void addOrder(Orders orders);

    @Delete("update train_date set second_available = second_available - 1 where id = #{dateId}")
    void reduceSeatNum(long dateId);

    /**
     * 添加票务信息
     * @param tickets
     */
    @Insert("insert into tickets (seat_id, order_id, passenger_name, passenger_id, seat_type, seat_number, carriage_number, price) values (#{seatId}, #{orderId}, #{passengerName}, #{passengerId}, #{seatType}, #{seatNumber}, #{carriageNumber}, #{price})")
    void addTicket(Tickets tickets);
}
