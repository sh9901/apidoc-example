package com.example.vo.request;

import com.example.constraint.CaseMode;
import com.example.constraint.CheckCase;
import com.example.enums.RoleEnum;
import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {

    @Positive(message = "修改用户时需要提供userId")
    private int userId;

    @CheckCase(value = CaseMode.UPPER, message = "userName需要大写")
    private String userName;

    @Size(min = 3, max = 6, message = "密码长度3-6位")
    private String password;


    private String skinColor;

    private RoleEnum roleEnum;
}
