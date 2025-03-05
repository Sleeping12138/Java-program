package com.test.spring2025_3_5.Mapper;

import com.test.spring2025_3_5.Model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Delete("DELETE FROM user_info WHERE id = #{id}")
    Integer deleteUser(Integer id);

    @Update("UPDATE user_info SET `password` = 54321 WHERE id = #{id}")
    Integer updateUser(Integer id);

    List<UserInfo> selectUserInfo(@Param("ID") Integer id);

    Integer insertUserInfo(String username,String password,Integer age);

    Integer deleteUserInfo(Integer id);

    Integer updateUserInfo(UserInfo userInfo);
}


