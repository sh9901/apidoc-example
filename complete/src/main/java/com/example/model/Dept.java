package com.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class Dept {
    private int deptId;
    private int parentId;
    private String deptName;
    private Date createTime;
    private Date updateTime;
}
