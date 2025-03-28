package com.test.spring2025_3_28.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogInfoMapper {
    @Insert("insert into log_info(`user_name`,`op`)values(#{name},#{op})")
    Integer insertLog(String name,String op);
}
