package com.text.java2024_11_29.Demo1;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

// 使用writeValueAsString 和 readValue
public class demo1 {
//     JSON格式和对象的相互转化（使用ObjectMapper）
    @Test
    public void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 将对象转化为JSON
        Student student = new Student("zhangsan", 18, "male");
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }

    @Test
    public void test2() throws JsonProcessingException {
        // 将JSON转化为对象
        ObjectMapper objectMapper = new ObjectMapper();
        String temp = "{\"name\":\"zhangsan\",\"age\":18,\"sex\":\"male\"}";
        Student student = objectMapper.readValue(temp, Student.class);
        System.out.println(student.toString());

    }

    // 使用gson - fromJson 和 toJson
    @Test
    public void test3(){
        Gson gson = new Gson();
        String temp = "{\"name\":\"zhangsan\",\"age\":18,\"sex\":\"male\"}";
        Student student = gson.fromJson(temp, Student.class);
        System.out.println(student);
    }

    @Test
    public void test4(){
        Gson gson = new Gson();
        Student student = new Student("zhangsan", 18, "male");
        String json = gson.toJson(student);
        System.out.println(json);
    }

    // 使用fastjson
    @Test
    public void test5(){
        String temp = "{\"name\":\"zhangsan\",\"age\":18,\"sex\":\"male\"}";
        Student student = JSON.parseObject(temp, Student.class);
        System.out.println(student);
    }

    @Test
    public void test6(){
        Student student = new Student("zhangsan", 18, "male");
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
    }
}
