package com.mao.mysqlhive.demomh.service.primary.Impl;

import com.mao.mysqlhive.demomh.entity.User;
import com.mao.mysqlhive.demomh.mapper.primary.UserMapper;
import com.mao.mysqlhive.demomh.service.primary.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
