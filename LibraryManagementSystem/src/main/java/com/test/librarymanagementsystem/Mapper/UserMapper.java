package com.test.librarymanagementsystem.Mapper;

import com.test.librarymanagementsystem.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where user_name = #{userName};")
    UserInfo selectUserInfo(String userName);
}
