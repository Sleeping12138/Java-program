package com.test.java2025_1_21;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class userController {
    @RequestMapping("/login")
    public boolean userLogin(String userName, String password, HttpSession httpSession) {

        // 使用StringUtils来判断字符串
        if(!StringUtils.hasLength(userName)||!StringUtils.hasLength(password)){
            return false;
        }
        String user = "zhangsan",pwd = "123456";

        if("zhangsan".equals(userName)&&"123456".equals(password)){
            httpSession.setAttribute("zhangsan","zhangsan");
            return true;
        }
        return false;
    }
    @RequestMapping("/getLoginUser")
    public String getUserName(HttpServletRequest request){
        HttpSession session = request.getSession();
        String ret = (String) session.getAttribute("zhangsan");
        if (StringUtils.hasLength(ret)) {
            return ret;
        }
        return "";
    }

    public String test(){
        Student student = new Student();
        return null;
    }
}
