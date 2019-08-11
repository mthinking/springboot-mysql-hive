package com.mao.mysqlhive.demomh.service.back;

import com.mao.mysqlhive.demomh.entity.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有
     */
    List<Account> getAccountList();
}
