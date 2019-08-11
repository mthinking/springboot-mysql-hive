package com.mao.mysqlhive.demomh.controller;

import com.mao.mysqlhive.demomh.entity.User;
import com.mao.mysqlhive.demomh.service.primary.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * test2数据库 Controller
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/userList")
    public List<User> getUserList() {
        List<User> accounts = userService.getUserList();
        return accounts;
    }

}
