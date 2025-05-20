package com.example.tickets.service.impl;
import com.example.tickets.mapper.UserMapper;
import com.example.tickets.pojo.Result;
import com.example.tickets.pojo.entity.Users;
import com.example.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(Users map) {
        String UserName = map.getUsername();
        String Password = map.getPassword();
        Users users = userMapper.login(UserName, Password);
        if (users == null) {
            return Result.error("用户不存在");
        } else {
            if (Objects.equals(users.getUserType(), "user")) {
                return Result.success("用户登录成功");
            } else if (Objects.equals(users.getUserType(), "admin")) {
                return Result.success("管理员登录成功");
            }else  {
                return Result.error("用户数据错误");
            }
        }
    }
}
