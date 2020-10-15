package com.example.constraint;

import com.example.enums.RoleEnum;
import com.example.exception.CheckEnumException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * enun声明的枚举类型序列化时会检查枚举值是否合法，只有通过才会执行到这里，没有意义了？？
 */
public class CheckEnumValidator implements ConstraintValidator<CheckEnum, RoleEnum> {

    private RoleEnum[] roles;

    @Override
    public void initialize(CheckEnum constraint) {
        this.roles = constraint.anyOf();
    }

    @Override
    public boolean isValid(RoleEnum value, ConstraintValidatorContext context) {
//        return value == null || Arrays.asList(roles).contains(value);
        if (value == null || Arrays.asList(roles).contains(value)) {
            return true;
        } else {
            throw new CheckEnumException(value + "不在枚举中" + Arrays.asList(roles).toString());
        }
    }
}
