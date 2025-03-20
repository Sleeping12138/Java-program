package com.test.spring2025_3_20.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_info")
public class UserInfo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer userId;

    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;

    @TableField("delete_flag")
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
