package com.test.librarymanagement.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
