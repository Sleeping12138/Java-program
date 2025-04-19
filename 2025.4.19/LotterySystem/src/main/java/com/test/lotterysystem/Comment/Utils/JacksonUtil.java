package com.test.lotterysystem.Comment.Utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.concurrent.Callable;


// 将繁琐的异常处理进行了解决
public class JacksonUtil {
    /**
     * 工具类不需要创建实例对象
     */
    private JacksonUtil(){}

    /**
     * 给ObjectMapper进行单例模式，由于ObjectMapper 是线程安全的，可以复用，放置重复创建影响性能
     */
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

    // 普通对象和List对象共同使用
    public static String writeValueAsString(Object object){
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().writeValueAsString(object);
        });
    }

    // 普通对象的反序列化
    public static <T> T readValue(String str,Class<T> valueType){
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().readValue(str,valueType);
        });
    }

    // List类型的反序列化
    public static <T> T readListValue(String str,Class<?> valueType){
        JavaType javaType = JacksonUtil.getObjectMapper().getTypeFactory().constructParametricType(List.class,valueType);
        return JacksonUtil.tryParse(()->{
            return JacksonUtil.getObjectMapper().readValue(str,javaType);
        });
    }

}
