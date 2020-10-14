package com.example.service;

import com.example.vo.request.NewUserRequest;
import com.example.vo.request.UserFilterRequest;
import com.example.vo.request.UserLoginRequest;
import com.example.vo.response.UserDetailResponse;

import java.util.List;

public interface IUserService {
    boolean addUser(NewUserRequest userRequest);

    UserDetailResponse queryUserDetail(int userId);

    List<UserDetailResponse> queryUsers(UserFilterRequest filterRequest);

    List<UserDetailResponse> searchUsers(String userName,
                                         int gender,
                                         int age_min,
                                         int age_max,
                                         String skinColor);

    /**
     * 用户登录成功返回用户详情
     *
     * @return
     */
    UserDetailResponse loginUser(UserLoginRequest login);
}
