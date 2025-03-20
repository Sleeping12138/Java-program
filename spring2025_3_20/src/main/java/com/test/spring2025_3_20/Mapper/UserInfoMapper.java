package com.test.spring2025_3_20.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.test.spring2025_3_20.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select id,username,password,age FROM user_info ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoList(@Param(Constants.WRAPPER) QueryWrapper<UserInfo> queryWrapper);
}
