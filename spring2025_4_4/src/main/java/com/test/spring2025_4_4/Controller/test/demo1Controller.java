package com.test.spring2025_4_4.Controller.test;


import com.test.spring2025_4_4.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/demo1")
public class demo1Controller {

    @RequestMapping(value = "m1", method = {RequestMethod.POST, RequestMethod.GET})
    public String method1() {
        return "hello world";
    }

    @PostMapping("/m2")
    public String method2() {
        return "hello method2";
    }

    // 传递参数
    @RequestMapping("/m3")
    public String method3(String str) {
        return str;
    }

    @RequestMapping("/m4")
    public void method4(String str, Integer num) {
        System.out.println("str:" + str);
        System.out.println("num:" + num);
    }

    @RequestMapping("/m5")
    public void method5(Student student) {
        System.out.println(student.toString());
    }

    @RequestMapping("/m6")
    public String method6(@RequestParam(value = "str") String afoweifwij, @RequestParam(required = false) Integer number) {
        return afoweifwij + number;
    }

    // 接收数组
    @RequestMapping("/m7")
    public void method7(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // 接收集合
    @RequestMapping("/m8")
    public void method8(@RequestParam ArrayList<Integer> list) {
        System.out.println(list);
    }

    // 接收JSON
    @RequestMapping("/m9")
    public void method9(@RequestBody Student student){
        System.out.println(student.toString());
    }

    // 接收路径参数
    @RequestMapping("/m10/{id}/{number}")
    public void method10(@PathVariable Integer id,@PathVariable("number") Integer sfaoiweof){
        System.out.println(id+"----"+sfaoiweof);
    }
}
