package com.test.java2025_1_21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class calcController {

//    @RequestMapping("/test")
//    public String test(){
//        return "/calc.html";
//    }


    @RequestMapping("/sum")
    public String getSum(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "参数错误，请重新发送！！！";
        }
        return String.valueOf(num1+num2);
    }
}
