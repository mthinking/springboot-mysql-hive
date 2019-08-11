package com.mao.mysqlhive.demomh.service.hive;

import java.util.List;

public interface HiveService {

    /**
     * 查询hive连接库中所有表
     * @return
     */
    List<String> listAllTablesa();
}
