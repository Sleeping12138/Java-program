package com.test.spring2025_5_3.Demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String name;
    private Integer age;
}
