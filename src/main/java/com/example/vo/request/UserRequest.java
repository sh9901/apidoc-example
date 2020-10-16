package com.example.vo.request;

import com.example.constraint.OnAdd;
import com.example.constraint.OnUpdate;
import com.example.enums.RoleEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
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

    /**
     * 该字段在生成的swagger-doc中无法将@NotEmpty翻译为required=true
     * 若使用@NotNull则可以处理为required=true，但无法验证updateReason=“”的场景，并不适用
     * 额外的@ApiModelProperty(required = true)也是不适用的，因为不应该约束OnAdd场景
     * 综上，分组约束违背了职责单一原则，给验证和文档明晰带来了冲突
     */
    @NotEmpty(groups = {OnUpdate.class}, message = "修改原因不能为空")
    private String updateReason;
}
