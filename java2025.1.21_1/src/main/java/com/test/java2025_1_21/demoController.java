package com.test.java2025_1_21;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/demo")
//@RestController
//@Controller
public class demoController {
    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }

    // 获取Cookie
    @RequestMapping("/cookie")
    public String getCookies(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName() + " --- " + cookie.getValue());
        }
        return "获取cookie成功!!!";
    }

    @RequestMapping("/getCookies")
    public String getCookies2(@CookieValue("zhangsan") String age) {
        return age;
    }

    // 设置cookie
    @RequestMapping("/setCookie")
    public String setCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("zhangsan", "18");
        response.addCookie(cookie);
        return "cookie设置成功!!!";
    }

    // session
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("lisi", 20);
        return "Session设置成功!!!";
    }

    @RequestMapping("/setSession2")
    public String setSession2(HttpSession session) {
        session.setAttribute("wangwu", 22);
        return "Session设置成功!!!";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String ret = (String) session.getAttribute("lisi");
        return ret;
    }

    @RequestMapping("getSession2")
    public String getSession2(HttpSession session) {
        return (String) session.getAttribute("wangwu");
    }

    @RequestMapping("getSession3")
    public String getSession3(@SessionAttribute(value = "wangwu", required = false) String ret) {
        return ret;
    }

    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String ret) {
        return ret;
    }

    @RequestMapping("/setHeader")
    public String setHeader(HttpServletResponse response) {
        response.setHeader("aaa", "aaa");
        return "响应头设置成功！！！";
    }

    @RequestMapping(value = "/getHTML")
    public String getHTML() {
        return "/index.html";
    }

    @RequestMapping("/returnJSON")
    public ArrayList<Integer> getJSON() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        return list;
    }

    @RequestMapping("/setStatue")
    public String setStatue(HttpServletResponse response) {
        response.setStatus(404);
        return "响应状态码设置成功！！！";
    }
}
