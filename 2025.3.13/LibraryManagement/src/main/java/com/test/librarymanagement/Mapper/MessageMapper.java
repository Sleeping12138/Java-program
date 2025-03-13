package com.test.librarymanagement.Mapper;

import com.test.librarymanagement.Model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM message_info")
    public List<Message> selectAllMessage();

    @Insert("INSERT INTO message_info (`from`,`to`,message) VALUES (#{from},#{to},#{message})")
    void insertMessage(Message message);
}
