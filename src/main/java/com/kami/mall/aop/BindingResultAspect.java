package com.kami.mall.aop;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.ResultModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author yangzi
 * @date 2021-06-24 2:36 PM
 */
@Aspect
@Component
@Order(2)
public class BindingResultAspect {

    @Pointcut("execution(public * com.kami.mall.web.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAroud(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if (fieldError != null) {
                        return ResultModel.fail(CommonErrorCode.VALIDATE_ERROR, fieldError.getDefaultMessage());
                    } else {
                        return ResultModel.fail(CommonErrorCode.ERROR_AUTH);
                    }

                }
            }
        }
        return joinPoint.proceed();
    }
}
