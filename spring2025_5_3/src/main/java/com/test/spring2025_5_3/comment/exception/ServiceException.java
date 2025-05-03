package com.test.spring2025_5_3.comment.exception;

import com.test.spring2025_5_3.comment.errorCode.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {
    private Integer code;
    private String errMsg;

    public ServiceException() {

    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.errMsg = errorCode.getErrorMessage();
    }
}
