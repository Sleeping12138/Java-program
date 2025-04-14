package com.test.webchat.Mapper;

import com.test.webchat.Pojo.Model.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageSessionUserMapper {

    @Select("SELECT session_id FROM message_session WHERE session_id " +
            "IN (SELECT session_id FROM message_session_user where user_id = #{userId}) " +
            "ORDER BY last_time desc")
    List<Integer> getSessionIdsByUserId(int userId);


    // 如果返回数据为多个，其会按照字段名称来封装为一个对象
    @Select("SELECT user_id as friendId, user_name as friendName  FROM user_info WHERE user_id " +
            "in (SELECT user_id FROM  message_session_user " +
            "WHERE session_id = #{sessionId} AND user_id != #{userId})")
    List<Friend> getFriendsBySessionId(Integer sessionId, Integer userId);
}
