package com.test.lotterysystem.Comment.Exception;

import com.test.lotterysystem.Comment.ErrorCode.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControllerException extends RuntimeException {
    private Integer code;
    private String errMsg;

    public ControllerException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.errMsg = errorCode.getErrMsg();
    }
}
