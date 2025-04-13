package com.test.webchat.Pojo.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoSimple {
    private Integer userId;
    private String userName;
}
