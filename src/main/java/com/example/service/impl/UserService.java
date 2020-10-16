package com.example.service.impl;

import com.example.model.Dept;
import com.example.service.IUserService;
import com.example.vo.request.UserAddRequest;
import com.example.vo.request.UserFilterRequest;
import com.example.vo.request.UserLoginRequest;
import com.example.vo.request.UserUpdateRequest;
import com.example.vo.response.UserDetailResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public boolean addUser(UserAddRequest userRequest) {
        return true;
    }

    @Override
    public boolean updateUser(UserUpdateRequest userRequest) {
        return true;
    }

    @Override
    public UserDetailResponse queryUserDetail(int userId) {
        UserDetailResponse user = new UserDetailResponse();
        user.setUserId(1);
        user.setGender(1);
        user.setUserName("username-queryUserDetail");

        Dept dept = new Dept(1, 0, "QA", new Date(), new Date());
        user.setDept(dept);
        return user;
    }

    @Override
    public List<UserDetailResponse> queryUsers(UserFilterRequest filterRequest) {
        UserDetailResponse user = new UserDetailResponse();
        user.setUserId(1);
        user.setGender(filterRequest.getGender());
        user.setUserName("username-queryUsers");

        Dept dept = new Dept(1, 0, "QA", new Date(), new Date());
        user.setDept(dept);

        List<UserDetailResponse> users = new ArrayList<UserDetailResponse>();
        users.add(user);
        return users;
    }

    @Override
    public List<UserDetailResponse> searchUsers(
            String userName, int gender, int age_min, int age_max, String skinColor) {
        return null;
    }

    @Override
    public UserDetailResponse loginUser(UserLoginRequest login) {
        return null;
    }
}
