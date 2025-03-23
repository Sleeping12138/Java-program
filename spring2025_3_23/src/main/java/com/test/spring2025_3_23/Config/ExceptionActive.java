package com.test.spring2025_3_23.Config;

import com.test.spring2025_3_23.Model.Result;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionActive {

    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handler2(Exception e) {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Result handler3(Exception e) {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result handler4(Exception e) {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result handler(NullPointerException e) {
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result handler(ArrayIndexOutOfBoundsException e) {
        return Result.fail(e.getMessage());
    }

}


