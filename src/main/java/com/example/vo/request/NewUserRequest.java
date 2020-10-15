package com.example.vo.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Data
public class NewUserRequest {
    private String userName;
    private String password;


    private int gender;
}
