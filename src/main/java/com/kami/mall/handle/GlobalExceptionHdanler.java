package com.kami.mall.handle;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangzi
 * @date 2021-06-24 3:12 PM
 */
//@ControllerAdvice
//public class GlobalExceptionHdanler {
//
//    @ResponseBody
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResultModel handleValidException(MethodArgumentNotValidException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        String message = null;
//        if (bindingResult.hasErrors()) {
//            FieldError fieldError = bindingResult.getFieldError();
//            if (fieldError != null) {
//                message = fieldError.getField() + fieldError.getDefaultMessage();
//            }
//        }
//        return ResultModel.fail(CommonErrorCode.VALIDATE_ERROR, message);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(value = BindException.class)
//    public ResultModel handleValidException(BindException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        String message = null;
//        if (bindingResult.hasErrors()) {
//            FieldError fieldError = bindingResult.getFieldError();
//            if (fieldError != null) {
//                message = fieldError.getField() + fieldError.getDefaultMessage();
//            }
//        }
//        return ResultModel.fail(CommonErrorCode.VALIDATE_ERROR, message);
//    }
//}
