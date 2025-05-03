package com.test.spring2025_5_3.comment.errorCode;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



// 错误码一般使用接口 + 枚举类的方式
@NoArgsConstructor
@AllArgsConstructor
public enum  GlobalErrorCode implements ErrorCode{
    SUCCESS(200,"achieve");

    private Integer code;
    private String errorMsg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return errorMsg;
    }

    public static GlobalErrorCode forName(String name){
        for (GlobalErrorCode value : GlobalErrorCode.values()) {
            if (name.equalsIgnoreCase(value.name())) {
                return value;
            }
        }
        return null;
    }
}
