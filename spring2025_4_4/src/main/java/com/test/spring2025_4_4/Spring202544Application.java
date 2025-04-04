package com.test.spring2025_4_4;

import com.test.spring2025_4_4.Controller.test.demoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("")
public class Spring202544Application {
    public static void main(String[] args) {
        SpringApplication.run(Spring202544Application.class, args);

//        ApplicationContext context = SpringApplication.run(Spring202544Application.class, args);
//        // 使用类名
//        demoController bean = context.getBean(demoController.class);
//        // 使用容器中的名称
//        demoController demo = (demoController) context.getBean("demo");
//        // 使用容器中的名称 + 类名
//        demoController bean1 = context.getBean("demo", demoController.class);
    }

}
