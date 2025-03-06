package com.test.spring2025_3_6.Mapper;

import com.test.spring2025_3_6.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> selectUserInfo();

    @Select("select id, username, age, gender, phone, delete_flag, create_time, update_time "
            + "from user_info order by id #{sort} ")
    List<UserInfo> queryAllUserBySort(String sort);

    @Select("select id, username, age, gender, phone, delete_flag, create_time, update_time " +
            "from user_info where username like '%#{key}%' ")
    List<UserInfo> queryAllUserByLike(String key);

    @Select("select id, username, age, gender, phone, delete_flag, create_time, update_time " +
            "from user_info where username like concat('%',#{key},'%')")
    List<UserInfo> queryAllUserByLike2(String key);
}
