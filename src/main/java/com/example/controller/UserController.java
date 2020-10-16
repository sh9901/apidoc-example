package com.example.controller;


import com.example.constraint.CaseMode;
import com.example.constraint.CheckCase;
import com.example.constraint.OnAdd;
import com.example.constraint.OnUpdate;
import com.example.service.IUserService;
import com.example.vo.request.*;
import com.example.vo.response.UserDetailResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Api
@Validated
@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/user/")
    boolean addUser(@Valid @RequestBody UserAddRequest user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/user/")
    boolean updateUser(@Valid @RequestBody UserUpdateRequest user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "共用UserRequest添加用户")
    @PostMapping("/user/add")
    @Validated(OnAdd.class)
    boolean addUser(@Valid @RequestBody UserRequest user) {
        return true;
    }

    @ApiOperation(value = "共用UserRequest修改用户")
    @PutMapping("/user/update")
    boolean updateUser(@Validated(OnUpdate.class) @RequestBody UserRequest user) {
        return true;
    }

    /**
     * 使用用户ID查询用户详细信息
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "按用户ID查询用户详情")
    @ApiImplicitParam(name = "userId", example = "100")
    @GetMapping("/user/{userId}")
    UserDetailResponse queryUser(@Positive @PathVariable int userId) {
        return userService.queryUserDetail(userId);
    }

    /**
     * 使用ResponseControllerAdvice之后ResultVO<>返回类型可以去掉
     *
     * @param filter
     * @return
     */
    @ApiOperation(value = "组合查询用户信息")
    @PostMapping("/user/query")
    List<UserDetailResponse> queryUsers(@Valid @RequestBody UserFilterRequest filter) {
        return userService.queryUsers(filter);
    }

    @ApiOperation(value = "搜索用户")
    @GetMapping("/user/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", example = "ABC"),
            @ApiImplicitParam(name = "gender", value = "性别", allowableValues = "0,1", example = "1"),
            @ApiImplicitParam(name = "minAge", value = "筛选年龄大于", required = true, example = "18", dataType = "int"),
            //dataType不指定会影响swagger-doc中type,maxLength/maximum,x-example的正确生成
            @ApiImplicitParam(name = "maxAge", value = "筛选年龄小于", required = true, example = "60"),
            @ApiImplicitParam(name = "skinColor", value = "筛选肤色", required = true, allowableValues = "yellow,white,black", example = "black")
    })
    List<UserDetailResponse> searchUsers(
            @RequestParam @CheckCase(CaseMode.UPPER) String userName,
            @RequestParam(required = false) @Min(value = 0, message = "性别最小取值0") @Max(value = 1, message = "性别最大取值1") int gender,
            @RequestParam(value = "minAge") @Min(18) int ageMin,
            @RequestParam(value = "maxAge") @Max(60) @NotNull int ageMax,
            @RequestParam @NotEmpty String skinColor) {
        return userService.searchUsers(userName, gender, ageMin, ageMax, skinColor);
    }

    @ApiOperation("用户登录")
    @PostMapping("/user/login")
    UserDetailResponse loginUser(@Valid @RequestBody UserLoginRequest loginUser) {
        return userService.loginUser(loginUser);
    }
}
