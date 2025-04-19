package com.test.lotterysystem.Comment.Pojo;

import com.test.lotterysystem.Comment.ErrorCode.ErrorCode;
import com.test.lotterysystem.Comment.ErrorCode.GlobalErrorCodeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> CommentResult<T> success(T data) {
        CommentResult<T> commentResult = new CommentResult<>();
        commentResult.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        commentResult.setMsg(null);
        commentResult.setData(data);
        return commentResult;
    }

    public static <T> CommentResult<T> fail(Integer code,String msg){
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code),"code 不是错误的异常");
        CommentResult<T> commentResult = new CommentResult<>();
        commentResult.setCode(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode());
        commentResult.setMsg(null);
        commentResult.setMsg(msg);
        return commentResult;
    }

    public static <T> CommentResult<T> fail(ErrorCode errorCode){
        return CommentResult.fail(errorCode.getCode(),errorCode.getErrMsg());
    }

}
