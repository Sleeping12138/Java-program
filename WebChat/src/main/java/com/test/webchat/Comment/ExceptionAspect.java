package com.test.webchat.Comment;

import com.test.webchat.Pojo.Response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAspect {
    @ExceptionHandler
    public Result handler(Exception e) {
        log.info("错误信息为：{}", e);
        return Result.fail(e.getMessage());
    }
}
