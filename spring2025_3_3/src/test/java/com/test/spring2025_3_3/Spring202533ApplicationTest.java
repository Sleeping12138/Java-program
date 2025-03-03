package com.test.spring2025_3_3;

import com.test.spring2025_3_3.Mapper.UserInfoMapper;
import com.test.spring2025_3_3.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Spring202533ApplicationTest {

    // ApplicationContext是可以直接进行注入的
    @Autowired
    private ApplicationContext context;

    @Test
    public void getList(){
        UserInfoMapper bean = context.getBean(UserInfoMapper.class);
        System.out.println(bean.getList());
    }
}