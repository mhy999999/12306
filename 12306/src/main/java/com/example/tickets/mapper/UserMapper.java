package com.example.tickets.mapper;

import com.example.tickets.pojo.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Users login(String username, String password);
}
