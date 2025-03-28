package com.test.spring2025_3_28.Service;

import com.test.spring2025_3_28.Mapper.LogInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;
    public void insertLog(String name,String op){
//记录用户操作
        logInfoMapper.insertLog(name,"用户注册");
    }
}
