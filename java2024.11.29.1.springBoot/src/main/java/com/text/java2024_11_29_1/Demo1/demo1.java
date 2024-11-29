package com.text.java2024_11_29_1.Demo1;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/demo1")
public class demo1 {
    @RequestMapping("/test/{id}")
    public String test(@PathVariable String id) {
        return id;
    }

    // 每个参数前面都要使用PathVariable
    @RequestMapping("/test/{id}/{number}")
    public String test(@PathVariable("number") Integer n, @PathVariable String id) {
        return n + " " + id;
    }

    // 接收JSON格式的数据
    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        return student.toString();
    }

    // 上传文件
    @RequestMapping("/test3")
    public String test3(@RequestPart("file") MultipartFile file){
        // 对文件的使用
        // InputStream inputStream = file.getInputStream();

        String name = file.getOriginalFilename();
        return name;
    }
}
