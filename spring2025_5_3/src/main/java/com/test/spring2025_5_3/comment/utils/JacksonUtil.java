package com.test.spring2025_5_3.comment.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;

import java.util.List;
import java.util.concurrent.Callable;

public class JacksonUtil {
    private JacksonUtil(){};

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static ObjectMapper getObjectMapper(){
        return objectMapper;
    }

    public static final <T> T tryParse(Callable<T> parser) {
        return JacksonUtil.tryParse(parser, JacksonException.class);
    }

    public static final <T> T tryParse(Callable<T> parser, Class<? extends Exception> check) {
        try {
            return parser.call();
        }
        catch (Exception ex) {
            if (check.isAssignableFrom(ex.getClass())) {
                throw new JsonParseException(ex);
            }
            throw new IllegalStateException(ex);
        }
    }

    public static String writeValueAsString(Object object) {
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().writeValueAsString(object);
        });
    }

    public static <T> T readValue(String str,Class<T> valueType){
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().readValue(str,valueType);
        });
    }

    public static <T> T readListValue(String str,Class<T> valueType){
        JavaType javaType = JacksonUtil.getObjectMapper().getTypeFactory().constructParametricType(List.class,valueType);
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().readValue(str,javaType);
        });
    }

}
