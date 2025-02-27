package com.test.spring2025_2_27.Mapper;


import com.test.spring2025_2_27.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info")
    List<UserInfo> getList();
}
