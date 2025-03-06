package com.test.spring2025_3_6.Model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    //用户相关信息
    private String username;
    private Integer age;
    private Integer gender;
}
