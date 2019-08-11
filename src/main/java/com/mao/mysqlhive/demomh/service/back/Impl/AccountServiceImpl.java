package com.mao.mysqlhive.demomh.service.back.Impl;

import com.mao.mysqlhive.demomh.entity.Account;
import com.mao.mysqlhive.demomh.mapper.back.AccountMapper;
import com.mao.mysqlhive.demomh.service.back.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public List<Account> getAccountList() {
        return accountMapper.getAccountList();
    }
}
