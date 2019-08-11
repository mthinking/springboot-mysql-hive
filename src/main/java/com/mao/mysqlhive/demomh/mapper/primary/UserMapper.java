package com.mao.mysqlhive.demomh.mapper.primary;

import com.mao.mysqlhive.demomh.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户信息
     */
    List<User> getUserList();
}
