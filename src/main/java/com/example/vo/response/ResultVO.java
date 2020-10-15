package com.example.vo.response;

import com.example.common.ResultCode;
import lombok.Getter;

@Getter
public class ResultVO<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, "success", data);
    }

    public ResultVO(ResultCode resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.msg = msg != null ? msg : resultCode.getMsg();
        this.data = data;
    }
}