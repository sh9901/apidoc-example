package com.example.vo.request;

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
    @Min(value = 0, message = "女")
    @Max(value = 1, message = "男")
    @ApiModelProperty(required = true, example = "1", allowableValues = "0,1")
    private int gender;

    @NotNull(message = "筛选用户名不可以为空")
    @ApiModelProperty(required = true)
    private String userName;
}
