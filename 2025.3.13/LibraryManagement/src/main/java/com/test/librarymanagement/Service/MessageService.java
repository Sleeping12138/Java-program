package com.test.librarymanagement.Service;

import com.test.librarymanagement.Mapper.MessageMapper;
import com.test.librarymanagement.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper mapper;
    public List<Message> getListService() {
        return mapper.selectAllMessage();
    }

    public void addMessage(Message message) {
        mapper.insertMessage(message);
    }
}
