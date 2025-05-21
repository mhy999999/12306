package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Orders;
import com.example.tickets.pojo.entity.Tickets;
import com.example.tickets.pojo.vo.OrderInfoVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {


    List<OrderInfoVO> getOrderByUerId(Integer userId);
}
