package com.example.vo.response;

import com.example.model.Dept;
import lombok.Data;

@Data
public class UserDetailResponse {
    private int userId;
    private String userName;
    private int gender;
    private Dept dept;
}
