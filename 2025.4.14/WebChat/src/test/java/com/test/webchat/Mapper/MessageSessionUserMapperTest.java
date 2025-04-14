package com.test.webchat.Mapper;

import com.test.webchat.Pojo.Model.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageSessionUserMapperTest {
    @Autowired
    private MessageSessionUserMapper messageSessionUserMapper;

    @Test
    void getSessionIdsByUserId() {
        List<Integer> sessionIdsByUserId = messageSessionUserMapper.getSessionIdsByUserId(1);
        System.out.println(sessionIdsByUserId);
    }

    @Test
    void getFriendsBySessionId() {
        List<Friend> friendsBySessionId = messageSessionUserMapper.getFriendsBySessionId(1, 1);
        System.out.println(friendsBySessionId);
    }
}