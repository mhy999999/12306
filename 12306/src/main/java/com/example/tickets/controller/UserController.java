package com.example.tickets.controller;

import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Users;
import com.example.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param users
     */
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/user/login")
    public Result login(@RequestBody Users users){
        Result result =userService.login(users);
        return result;
    }

}
