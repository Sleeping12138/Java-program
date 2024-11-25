package com.text.java2024_11_25;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

// 创建一个连接
@RequestMapping("/demo3") // 用于绑定路径映射
@RestController
public class demo3Controller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/method",method = RequestMethod.GET)
    public Integer method(Integer number){
        return number;
    }

    @PostMapping("/method2")
    public String method2(String str,Integer number){
        return str + " "+ number;
    }

    @RequestMapping(value = "/method3",method = RequestMethod.GET)
    public String method3(People people){
        return people.toString();
    }

    // 接收变量的重命名
//    @RequestMapping("method4")
//    public String method4(@RequestParam("qqq") String str){
//        return str;
//    }

    @RequestMapping("/method5")
    public ArrayList<Integer> method5(@RequestParam ArrayList<Integer> list) {
        return list;
    }

    @RequestMapping("/method6")
    public String method6(String[] str){
        return Arrays.toString(str);
    }

}
