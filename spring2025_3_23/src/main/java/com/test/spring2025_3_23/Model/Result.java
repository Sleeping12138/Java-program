package com.test.spring2025_3_23.Model;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String errMsg;
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        result.setCode(-1);
        result.setErrMsg("error");
        result.setData(data);
        return result;
    }
}
