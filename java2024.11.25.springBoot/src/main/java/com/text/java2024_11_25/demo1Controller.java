package com.text.java2024_11_25;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RequestMapping("/demo1")
@RestController
public class demo1Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello() {
        return "hello spring!";
    }

    @PostMapping("method1")
    public String method1() {
        return "hello spring!";
    }

    @GetMapping("method2")
    public String method2() {
        return "hello spring!";
    }

    @RequestMapping("method3")
    public String method3(String str, Integer number) {
        return str + " " + number;
    }

    @RequestMapping("method4")
    public String method4(Student student) {
        return student.toString();
    }

    @RequestMapping("method5")
    public String method5(@RequestParam(value = "q") String str) {
        return str;
    }

    @RequestMapping("method6")
    public ArrayList<Integer> method6(@RequestParam ArrayList<Integer> list) {
        return list;
    }
}
