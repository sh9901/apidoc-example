package com.example.vo.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class UserFilterRequest {
    @Min(value = 0, message = "女")
    @Max(value = 1, message = "男")
    private Integer gender;

    @NotNull(message = "筛选用户名不可以为空")
    private String userName;
}
