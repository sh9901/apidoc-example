package com.example.vo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class UserLoginRequest {

    @NotEmpty(message = "登录用户名必填")
    private String userName;

    @NotNull(message = "登录密码不能为空")
    private String password;
}
