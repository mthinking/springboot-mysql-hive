package com.mao.mysqlhive.demomh.controller;

import com.mao.mysqlhive.demomh.service.hive.HiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * hive Controller
 */
@Controller
@RequestMapping("/hive")
public class HiveController {


    @Autowired
    private HiveService hiveService;

    @ResponseBody
    @RequestMapping(value = "/tbList", method = RequestMethod.GET)
    public List<String> listAllTablesa2(){
        List<String> tbList = hiveService.listAllTablesa();
        return tbList;
    }



}
