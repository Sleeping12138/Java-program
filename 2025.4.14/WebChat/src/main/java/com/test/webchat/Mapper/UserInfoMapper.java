package com.test.webchat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.webchat.Pojo.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
