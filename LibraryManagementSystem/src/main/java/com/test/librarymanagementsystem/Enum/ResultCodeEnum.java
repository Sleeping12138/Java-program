package com.test.librarymanagementsystem.Enum;

public enum ResultCodeEnum {
    UNLOGIN(-1),
    SUCCESS(200),
    FAIL(-2);

    private Integer code;

    ResultCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
