package com.test.webchat.Pojo.Response;

import com.test.webchat.Enum.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private ResultCodeEnum code;
    private String errMsg;
    private Object data;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static Result fail(String error){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(error);
        return result;
    }
}
