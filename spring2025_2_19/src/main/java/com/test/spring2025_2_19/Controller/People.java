package com.test.spring2025_2_19.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class People {
    private String name;
    private int age;
    private String sex;
}
