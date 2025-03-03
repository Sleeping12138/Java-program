package com.test.spring2025_3_3.Mapper;

import com.test.spring2025_3_3.Model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT * from user_info")
    public abstract List<UserInfo> getList();


//    @Select("SELECT * FROM user_info WHERE username = 'zhangsan'")
//    public abstract List<UserInfo> getListByUserName();

    @Result
    @Select("SELECT * FROM user_info WHERE username = #{username}")
    public abstract List<UserInfo> getListByUserName(String username);

    @ResultMap("base")
    @Select("SELECT * FROM user_info WHERE username = #{name} AND age = #{a}")
    public abstract List<UserInfo> getListByNameAndAge(@Param("name") String username,@Param("a") Integer age);


    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO user_info (username,`password`,age) " +
            "VALUES (#{userInfo.username},#{userInfo.password},#{userInfo.age})")
    public abstract Integer addListByNameAndAge2(@Param("userInfo") UserInfo userInfo);

}
