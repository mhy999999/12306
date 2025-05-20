package com.example.tickets.service;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Users;

public interface UserService {
    Result login(Users map);
}
