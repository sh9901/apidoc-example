package com.example.exception;

import com.example.common.ResultCode;
import lombok.Getter;

@Getter
public class CheckEnumException extends RuntimeException {
    private final int code;
    private final String message;

    public CheckEnumException() {
        this.code = ResultCode.ItemNotImEnum.getCode();
        this.message = ResultCode.ItemNotImEnum.getMsg();
    }

    public CheckEnumException(String msg) {
        this.code = ResultCode.ItemNotImEnum.getCode();
        this.message = msg;
    }
}
