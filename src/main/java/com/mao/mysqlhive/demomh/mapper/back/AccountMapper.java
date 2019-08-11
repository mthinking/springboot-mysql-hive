package com.mao.mysqlhive.demomh.mapper.back;

import com.mao.mysqlhive.demomh.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AccountMapper {

	/**
	 * 查询所有
	 */
	List<Account> getAccountList();
}
