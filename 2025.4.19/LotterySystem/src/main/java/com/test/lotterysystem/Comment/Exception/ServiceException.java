package com.test.lotterysystem.Comment.Exception;

import com.test.lotterysystem.Comment.ErrorCode.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException{
    private Integer code;
    private String errMsg;
    public ServiceException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.errMsg = errorCode.getErrMsg();
    }
}
