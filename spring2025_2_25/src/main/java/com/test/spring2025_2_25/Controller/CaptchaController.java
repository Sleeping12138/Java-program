package com.test.spring2025_2_25.Controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {

    @Autowired
    public Captcha captcha2;

    private static final long TIME_LIMIT = 30 * 60 * 1000L;

    //    获取验证码
    @RequestMapping("/get")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("Progma", "No-cahce");

        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captcha2.getWidth(), captcha2.getHeight());

        String code = lineCaptcha.getCode();
        session.setAttribute(captcha2.getSession().getCode(), code);
        session.setAttribute(captcha2.getSession().getTime(), new Date());

        try {
            lineCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // 检查验证码是否正确
    @RequestMapping("/check")
    public boolean examCaptcha(String ret, HttpSession session) {
        if (!StringUtils.hasLength(ret)) return false;
        String code = (String) session.getAttribute(captcha2.getSession().getCode());
        Date time = (Date) session.getAttribute(captcha2.getSession().getTime());

        if (ret.equalsIgnoreCase(code) && time != null && System.currentTimeMillis() - time.getTime() < TIME_LIMIT) {
            return true;
        }
        return false;
    }
}
