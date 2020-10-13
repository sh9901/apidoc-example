package com.example.service.impl;

import com.example.service.IUserService;
import com.example.vo.request.NewUserRequest;
import com.example.vo.request.UserFilterRequest;
import com.example.vo.request.UserLoginRequest;
import com.example.vo.response.UserDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public boolean addUser(NewUserRequest userRequest) {
        return false;
    }

    @Override
    public UserDetailResponse queryUserDetail(int userId) {
        return null;
    }

    @Override
    public List<UserDetailResponse> queryUsers(UserFilterRequest filterRequest) {
        return null;
    }

    @Override
    public List<UserDetailResponse> searchUsers(String userName, int gender) {
        return null;
    }

    @Override
    public UserDetailResponse loginUser(UserLoginRequest login) {
        return null;
    }
}
