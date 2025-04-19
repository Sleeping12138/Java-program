package com.test.lotterysystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.lotterysystem.Comment.Pojo.CommentResult;
import com.test.lotterysystem.Comment.Utils.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JacksonTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test1() throws JsonProcessingException {
        CommentResult<String> object = CommentResult.success("hello world");
        String temp = objectMapper.writeValueAsString(object);
        System.out.println(temp);

        CommentResult commentResult = objectMapper.readValue(temp, CommentResult.class);
        System.out.println(commentResult.getData());
    }

    @Test
    public void test2() throws JsonProcessingException {
        List<CommentResult<String>> list = Arrays.asList(
                CommentResult.success("1111"),
                CommentResult.success("2222")
        );
        String temp = objectMapper.writeValueAsString(list);
        System.out.println(temp);

        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, CommentResult.class);
        list = objectMapper.readValue(temp, javaType);
        for (CommentResult<String> commentResult : list) {
            System.out.println(commentResult.getData());
        }
    }

    @Test
    public void test3() {
        CommentResult<String> object = CommentResult.success("hello world");
        String temp = JacksonUtil.writeValueAsString(object);
        System.out.println(temp);

        CommentResult commentResult = JacksonUtil.readValue(temp, CommentResult.class);
        System.out.println(commentResult.getData());
    }

    @Test
    public void test4() {
        List<CommentResult<String>> list = Arrays.asList(
                CommentResult.success("1111"),
                CommentResult.success("2222")
        );
        String temp = JacksonUtil.writeValueAsString(list);
        System.out.println(temp);

        list = JacksonUtil.readListValue(temp, CommentResult.class);
        for (CommentResult<String> commentResult : list) {
            System.out.println(commentResult.getData());
        }
    }

}
