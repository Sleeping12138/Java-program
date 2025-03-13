package com.test.librarymanagement.Controller;

import com.test.librarymanagement.Mapper.MessageMapper;
import com.test.librarymanagement.Model.Message;
import com.test.librarymanagement.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/getList")
    public List<Message> getList(){
        return messageService.getListService();
    }


    @RequestMapping("/publish")
    public void publish(Message message){
        messageService.addMessage(message);
    }
}
