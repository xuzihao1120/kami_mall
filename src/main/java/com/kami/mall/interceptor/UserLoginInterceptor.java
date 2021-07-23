package com.kami.mall.interceptor;

import com.kami.mall.config.CommonConfig;
import com.kami.mall.entity.bo.UserBO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author yangzi
 * @date 2021-07-13 3:31 PM
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserBO userBO = new UserBO();
        userBO.setName("yangzi");
        userBO.setMobile("18270347287");
        userBO.setPermissionKeyList(Arrays.asList("A", "B", "C", "D", "E"));
        HttpSession session = request.getSession();
        session.setAttribute(CommonConfig.LOGIN_USER, userBO);

        return true;
    }
}
