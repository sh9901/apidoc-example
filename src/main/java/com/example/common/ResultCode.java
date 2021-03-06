package com.example.common;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(0, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ItemNotImEnum(400001, "当前值不在枚举中"),
    ERROR(5000, "未知错误");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}