package com.example.vo.request;

import lombok.Data;

@Data
public class NewUserRequest {
    private String userName;
    private String password;
    private int gender;


}
