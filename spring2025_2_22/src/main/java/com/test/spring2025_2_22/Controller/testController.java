package com.test.spring2025_2_22.Controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class testController {

    @Value("${myKey}")
    private String myKey;

    @Value("${hello}")
    private String hello;

    @Value("${aa.bb.cc}")
    private Integer num;

    @Autowired
    private Student stu;


    @Autowired
    private ArrayTest list;

    @Autowired
    private MapTest map;

    @PostConstruct
    public void print() {
        System.out.println(myKey);
        System.out.println(hello);
        System.out.println(num);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(Arrays.toString(list.getNumber()));
        System.out.println(map.getStr());
    }
}
