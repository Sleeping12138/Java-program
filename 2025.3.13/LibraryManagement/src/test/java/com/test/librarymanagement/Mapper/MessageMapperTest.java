package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.Model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {
    @Autowired
    private MessageMapper mapper;

    @Test
    void selectAllMessage() {

    }

    @Test
    void insertMessage() {
        Message message = new Message();
        message.setFrom("aaa");
        message.setTo("bbb");
        message.setMessage("ccc");
        mapper.insertMessage(message);
    }
}