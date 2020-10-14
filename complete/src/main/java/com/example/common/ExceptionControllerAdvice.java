package com.example.common;

import com.example.exception.CheckEnumException;
import com.example.vo.response.ResultVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage(), null);
    }

    /**
     * TODO @PathVariable 中传的参数类型不对错误应该如何处理比较合适？
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO<String> MethodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        // 提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, e.getName() + "类型不匹配", null);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO<String> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, e.getMessage(), null);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO<String> MissingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, e.getMessage(), null);
    }

    /**
     * CheckEnumExceptionHandler 用于传值不属于枚举值时报错处理
     * CheckEnum没有生效，直接走到InvalidFormatExceptionHandler去了？？
     * 使用enum声明的枚举值被反序列化自动检查了，不需要再自定义？？
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CheckEnumException.class)
    public ResultVO<String> CheckEnumExceptionHandler(CheckEnumException e) {
        return new ResultVO<>(ResultCode.ItemNotImEnum, e.getMessage(), null);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResultVO<String> InvalidFormatExceptionHandler(InvalidFormatException e) {
        //TODO-e.getMessage 给出了内部异常
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, e.getMessage(), null);
    }
}
