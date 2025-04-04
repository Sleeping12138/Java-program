package com.test.spring2025_4_4.Config;

import com.test.spring2025_4_4.Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBean {
    @Bean({"stu","stu2","stu3"})
    public Student getStudent() {
        return new Student("zhangsan", 20, "male");
    }
}
