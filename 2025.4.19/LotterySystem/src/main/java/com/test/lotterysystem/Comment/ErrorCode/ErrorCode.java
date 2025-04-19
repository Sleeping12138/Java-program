package com.test.lotterysystem.Comment.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
    private Integer code;
    private String errMsg;
}
