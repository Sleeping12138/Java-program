package com.text.java2024_11_29.Demo1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo1")
@RestController
public class demo1 {
    @RequestMapping("/test/{id}")
    public String test(@PathVariable String id){
        return id;
    }
}
