package com.test.spring2025_2_19.Controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class demoController {

    public Student stu;

    public People people;

    public demoController() {
    }

    public demoController(Student stu) {
        this.stu = stu;
    }

    @Autowired
    public demoController(Student stu, People people) {
        this.stu = stu;
        this.people = people;
    }

//    @Value("${my.key}")
//    public String num;

    public void readStudent() {
        System.out.println(stu.toString());
        System.out.println(people.toString());
//        System.out.println(num);
    }

}
