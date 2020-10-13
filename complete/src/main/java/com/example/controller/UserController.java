package com.example.controller;


import com.example.service.IUserService;
import com.example.vo.request.NewUserRequest;
import com.example.vo.request.UserFilterRequest;
import com.example.vo.request.UserLoginRequest;
import com.example.vo.response.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    IUserService userService;


    @PostMapping("/user/")
    boolean addUser(@RequestBody NewUserRequest user) {
        return userService.addUser(user);
    }

    /**
     * 使用用户ID查询用户详细信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    UserDetailResponse queryUser(@PathVariable int userId) {
        return userService.queryUserDetail(userId);
    }

    @PostMapping("/user/query")
    List<UserDetailResponse> queryUsers(@RequestBody UserFilterRequest filter) {
        return userService.queryUsers(filter);
    }

    @GetMapping("/user/search")
    List<UserDetailResponse> searchUsers(
            @RequestParam String userName,
            @RequestParam(required = false) int gender) {
        return userService.searchUsers(userName, gender);
    }

    @PostMapping("/user/login")
    UserDetailResponse loginUser(@RequestBody UserLoginRequest loginUser) {
        return userService.loginUser(loginUser);
    }
}
