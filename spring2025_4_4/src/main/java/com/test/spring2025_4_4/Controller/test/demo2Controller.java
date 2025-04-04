package com.test.spring2025_4_4.Controller.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.spring2025_4_4.Model.Student;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/demo2")
@RestController
public class demo2Controller {

    // cookie的设置
    @RequestMapping("/setCookie")
    public String setCookie(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("name", "zhangsan");
        httpServletResponse.addCookie(cookie);
        return "finish";
    }

    @RequestMapping("getCookie1")
    public String getCookie1(HttpServletRequest httpServletRequest) {
        for (Cookie cookie : httpServletRequest.getCookies()) {
            System.out.println(cookie.getName() + "---" + cookie.getValue());
        }
        return "OK";
    }

    @RequestMapping("getCookie2")
    public String getCookie2(@CookieValue("name") String name) {
        return name;
    }

    // session的设置
    @RequestMapping("setSession")
    public void setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("zhangsan", 18);
        System.out.println("setSession OK...");
    }

    // 编程式事务
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/getSession")
    public Integer getSession(HttpServletRequest request) {
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            HttpSession session = request.getSession();
            Integer ret = (Integer) session.getAttribute("zhangsan");
            int a = 10 / 0;
            dataSourceTransactionManager.commit(transaction);
            return ret;
        } catch (TransactionException e) {
            dataSourceTransactionManager.rollback(transaction);
        }
        return 0;
    }

    @Transactional(rollbackFor = ArithmeticException.class)
    @RequestMapping("/getSession2")
    public Integer getSession2(@SessionAttribute("zhangsan") Integer age) {
        try {
            return age;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();;
        }
        return -1;
    }

    @RequestMapping("status")
    public void status(HttpServletResponse response) {
        response.setStatus(404);
    }

    @RequestMapping("test1")
    public Student test1() {
        return new Student("zhangsan", 18, "male");
    }

    // 使用ObjectMapper
    @RequestMapping("/test2")
    public String test2() throws JsonProcessingException {
        Student student = new Student("zhangsan", 20, "male");
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = objectMapper.writeValueAsString(student);
        return ret;
    }
}

