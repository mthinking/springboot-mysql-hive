package com.mao.mysqlhive.demomh.service.primary;

import com.mao.mysqlhive.demomh.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户信息
     */
    List<User> getUserList();
}
