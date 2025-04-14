package com.test.webchat.Pojo.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageSession {
    private Integer sessionId;
    private LocalDateTime lastTime;
}
