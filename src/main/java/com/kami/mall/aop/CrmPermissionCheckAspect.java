package com.kami.mall.aop;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.kami.mall.annotations.AuthorityPoint;
import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.CommonException;
import com.kami.mall.entity.bo.UserBO;
import com.kami.mall.utils.SessionHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzi
 * @date 2021-07-13 3:14 PM
 */
@Aspect
@Component
@Order(1)
public class CrmPermissionCheckAspect {
    private Logger logger = LoggerFactory.getLogger(CrmPermissionCheckAspect.class);

    @Pointcut("@annotation(com.kami.mall.annotations.AuthorityPoint)")
    public void adminRolePermission() {
    }

    @Before("adminRolePermission()")
    public void before(JoinPoint pig) {
        MethodSignature methodSign = (MethodSignature) pig.getSignature();
        Class targetClass = pig.getTarget().getClass();
        String methodSignName = methodSign.getMethod().getName();
        Method method = methodSign.getMethod();

        UserBO userInfo = SessionHolder.getUserInfo();
        logger.info("用户信息：{}", JSONObject.toJSONString(userInfo));
        AuthorityPoint authorityPoint = method.getAnnotation(AuthorityPoint.class);
        String[] accessPoint = authorityPoint.AccessPoint();
        ArrayList<String> accessPointList = Lists.newArrayList(accessPoint);
        List<String> permissionKeyList = userInfo.getPermissionKeyList();
        accessPointList.removeAll(permissionKeyList);

        logger.info("检查用户权限：{}", JSONObject.toJSONString(userInfo.getPermissionKeyList()));
        logger.info("{}-{}需要的权限为：{}", targetClass, methodSignName, JSONObject.toJSONString(accessPoint));

        // 判断是否具有权限
        if (accessPointList.size() > 0) {
            throw new CommonException(CommonErrorCode.NO_PERMISSION, "权限不足");
        }
    }

}