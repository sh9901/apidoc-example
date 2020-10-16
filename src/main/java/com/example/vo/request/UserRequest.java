package com.example.vo.request;

import com.example.constraint.OnAdd;
import com.example.constraint.OnUpdate;
import com.example.enums.RoleEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @Null(groups = {OnAdd.class})
    @NotNull(groups = {OnUpdate.class}, message = "修改用户userId不能为空")
    private int userId;

    @NotNull(groups = {OnAdd.class}, message = "新增用户userName不能为空")
    private String userName;

    @NotNull(groups = {OnAdd.class}, message = "新增用户密码不能为空")
    @Size(min = 3, max = 6, message = "用户密码长度3-6位")
    private String password;

    @NotNull(groups = {OnAdd.class}, message = "新增用户性别不能为空")
    private int gender;

    @NotNull(groups = {OnAdd.class}, message = "新增用户肤色不能为空")
    private String skinColor;

    @NotNull(groups = {OnAdd.class}, message = "新增用户角色不能为空")
    private RoleEnum roleEnum;
}
