package com.test.spring2025_4_4.Controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/demo")
@ResponseBody
@Controller("demo")
public class demoController {
    // 该类存储在IoC中的Bean的名称为demo

//    @Value("${my.key}")
//    Integer number;

//    @RequestMapping("/test")
//    public Integer test() {
//        return number;
//    }
}
