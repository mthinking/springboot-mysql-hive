package com.mao.mysqlhive.demomh.service.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HiveServiceImpl implements HiveService{


    @Autowired
    @Qualifier("hiveJdbcTemplate")
    private JdbcTemplate hiveJdbcTemplate;


    @Override
    public List<String> listAllTablesa() {
        List<String> list = new ArrayList<String>();
        List<Map<String, Object>> mapList = hiveJdbcTemplate.queryForList("show tables");
        for (Map<String, Object> map : mapList) {
            for (Map.Entry<String, Object> m : map.entrySet()) {
                list.add(m.getValue().toString());
                System.out.println(m.getValue());
            }
        }
        return list;
    }


}
