package com.example.vo.request;

import com.example.constraint.CaseMode;
import com.example.constraint.CheckCase;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "用户筛选请求")
public class UserFilterRequest {
    @Min(value = 0, message = "性别只支持0-女,1-男")
    @Max(value = 1, message = "性别只支持0-女,1-男")
    @ApiModelProperty(required = true, example = "1", allowableValues = "0,1")
    private int gender;

    @Min(value = 18, message = "最小年龄不能小于18")
    @Max(value = 60, message = "最大年龄不能大于60")
    private int age;

    @ApiModelProperty(required = true, example = "yellow", allowableValues = "yellow,white,black")
    @NotNull(message = "查询条件肤色不能为空")
    private String skinColor;

    @NotNull(message = "筛选用户名不可以为空")
    @ApiModelProperty(required = true)
    @Size(min = 2, max = 8, message = "用户名长度限制[2-8]")
    @CheckCase(value = CaseMode.UPPER, message = "userName需要大写")
    private String userName;
}
