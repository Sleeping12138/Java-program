package com.test.webchat.Pojo.Response;

import com.test.webchat.Pojo.Model.Friend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSession {
    private Integer sessionId;
    private List<Friend> friends;
    private String lastMessage;
}
