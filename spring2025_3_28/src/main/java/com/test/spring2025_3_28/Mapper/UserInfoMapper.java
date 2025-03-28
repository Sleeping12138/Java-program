package com.test.spring2025_3_28.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    @Insert("insert into user_info(`user_name`,`password`)values(#{name},#{password})")
    Integer insert(String name, String password);
}
