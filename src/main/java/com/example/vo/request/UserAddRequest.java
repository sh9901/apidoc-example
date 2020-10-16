package com.example.vo.request;


import com.example.constraint.CaseMode;
import com.example.constraint.CheckCase;
import com.example.enums.RoleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserAddRequest {

    @NotNull(message = "新增用户名不能为空")
    @Size(min = 2, max = 5, message = "用户名长度[2,5]")
    @CheckCase(value = CaseMode.UPPER, message = "userName需要大写")
    private String userName;

    /**
     * 可以增加密码复杂度自定义校验
     */
    @NotNull(message = "新增用户密码不能为空")
    @Size(min = 3, max = 6, message = "密码长度3-6位")
    private String password;

    /**
     * swagger-annotations无法对该@PositiveOrZero提供更多信息
     */
    @Min(value = 18, message = "新增用户年龄不能小于18岁")
    @Max(value = 60, message = "新增用户年龄不能大于60岁")
    private int age;

    /**
     * swagger-annotations无法对该@Digits提供更多信息
     */
    @Digits(integer = 1, fraction = 2)
    private float height;

    /**
     * swagger-annotations无法对@NotEmpty提供更多信息
     */
    @NotEmpty(message = "新增用户肤色不能为空")
    private String skinColor;

    @NotNull(message = "新增用户角色不能为空")
    private RoleEnum roleEnum;
}
