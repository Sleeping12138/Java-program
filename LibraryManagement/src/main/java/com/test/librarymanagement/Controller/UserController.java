package com.test.librarymanagement.Controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public boolean userName(String name, String password) {
        if(!StringUtils.hasLength(name)||!StringUtils.hasLength(password)) return false;
        if ("admin".equals(name) && "admin".equals(password)) {
            return true;
        }
        return false;
    }
}
