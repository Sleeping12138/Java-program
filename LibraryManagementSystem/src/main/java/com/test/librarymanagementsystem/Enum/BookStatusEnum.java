package com.test.librarymanagementsystem.Enum;

public enum BookStatusEnum {
    DELETE(0,"删除"),
    NORMAL(1,"正常"),
    FORBIDDEN(2,"不允许借阅");

    private Integer code;
    private String desc;

    BookStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getStatusByCode(int code){
        switch (code){
            case 0: return DELETE.getDesc();
            case 1: return NORMAL.getDesc();
            case 2: return FORBIDDEN.getDesc();
            default: return null;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
