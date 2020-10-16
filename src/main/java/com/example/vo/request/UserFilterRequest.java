package com.example.vo.request;

import com.example.constraint.CaseMode;
import com.example.constraint.CheckCase;
import com.example.constraint.CheckEnum;
import com.example.enums.RoleEnum;
import lombok.Data;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "用户筛选请求")
public class UserFilterRequest {
    @Min(value = 0, message = "性别最小取值为0-女")
    @Max(value = 1, message = "性别最大取值为1-男")
    @ApiModelProperty(required = true, example = "1", allowableValues = "0,1")
    private int gender;

    @Positive(message = "查询范围年龄最小值必填")
    private int minAge;

    @Positive(message = "查询范围年龄最大值必填")
    private int maxAge;

    /**
     * 类似枚举值validation需要自定义
     * 应该用enum类型的枚举值
     */
    @ApiModelProperty(required = true, example = "yellow", allowableValues = "yellow,white,black")
    @NotNull(message = "查询条件肤色不能为空")
    private String skinColor;


    /**
     * enum类型不需要自定义check
     * :@CheckEnum(anyOf = {RoleEnum.ADMIN, RoleEnum.MANAGER, RoleEnum.OPERATOR})
     * enum 类型不需要填写allowableValues,api-doc中可以自动获取
     */
    @ApiModelProperty(required = true, example = "OPERATOR")
    @NotNull(message = "用户角色不能为空")
    private RoleEnum roleEnum;

    @NotNull(message = "筛选用户名不可以为空")
    @ApiModelProperty(required = true)
    @Size(min = 2, max = 5, message = "用户名长度限制[2-5]")
    @CheckCase(value = CaseMode.UPPER, message = "userName需要大写")
    private String userName;
}
