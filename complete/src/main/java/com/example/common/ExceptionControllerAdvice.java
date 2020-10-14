package com.example.common;

import com.example.vo.response.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
}
