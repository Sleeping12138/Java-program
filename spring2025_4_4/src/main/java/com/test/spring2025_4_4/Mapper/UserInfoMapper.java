package com.test.spring2025_4_4.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.test.spring2025_4_4.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from user_info ${ew.customSqlSegment}")
    UserInfo getUserInfo(@Param(Constants.WRAPPER) QueryWrapper<UserInfo> queryWrapper);
}
