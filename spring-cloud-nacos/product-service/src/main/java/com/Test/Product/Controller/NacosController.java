package com.Test.Product.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/nacos")
public class NacosController {
    @Value("${nacos.test.num}")
    private Integer number;

    @RequestMapping("/get")
    public Integer get(){
        return number;
    }
}
