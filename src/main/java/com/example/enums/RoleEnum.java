package com.example.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN(1, "管理员"),
    MANAGER(2, "主管"),
    OPERATOR(3, "作业员");

    private final int roleCode;
    private final String roleName;

    RoleEnum(int code, String name) {
        this.roleCode = code;
        this.roleName = name;
    }
}
