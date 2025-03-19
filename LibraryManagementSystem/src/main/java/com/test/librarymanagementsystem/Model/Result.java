package com.test.librarymanagementsystem.Model;

import com.test.librarymanagementsystem.Enum.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private ResultCodeEnum code;
    private String errMsg;
    private T data;

    public static <T> Result<T> SUCCESS(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> FAIL(String errMsg){
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> UNLOGIN(){
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("未登录");
        result.setData(null);
        return result;
    }

}
