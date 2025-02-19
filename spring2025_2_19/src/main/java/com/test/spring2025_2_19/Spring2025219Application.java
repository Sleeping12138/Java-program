package com.test.spring2025_2_19;

import com.test.spring2025_2_19.Controller.demoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring2025219Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring2025219Application.class, args);
        demoController bean = context.getBean(demoController.class);
        bean.readStudent();
    }

}
