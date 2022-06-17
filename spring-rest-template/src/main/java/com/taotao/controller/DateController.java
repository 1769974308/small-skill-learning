package com.taotao.controller;

import com.taotao.damain.Data;
import com.taotao.damain.ResResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 * @date 2022/6/17
 */
@RestController
@RequestMapping("/data")
public class DateController {


    @RequestMapping("/list")
    public ResResult<List<Data>> getDateList(Integer reqId){
        Data data1 = new Data();
        data1.setTitle("taotao");
        data1.setContent("测试rest template");

        Data data2 = new Data();
        data2.setTitle("taotao2");
        data2.setContent("taotao2 测试rest template");

        List<Data> objects = new ArrayList<>();
        objects.add(data2);
        objects.add(data1);
        return new ResResult<>(objects);
    }

    @RequestMapping("/info")
    public ResResult<Data> getDateInfo(Integer reqId){
        Data data1 = new Data();
        data1.setTitle("taotao");
        data1.setContent("测试rest template");
        return new ResResult<>(data1);
    }


}
