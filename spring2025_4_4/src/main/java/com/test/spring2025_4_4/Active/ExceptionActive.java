package com.test.spring2025_4_4.Active;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionActive {
    @ExceptionHandler
    public void handler(Exception e){

    }
}
