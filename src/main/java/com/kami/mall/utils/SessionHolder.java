package com.kami.mall.utils;

import com.kami.mall.config.CommonConfig;
import com.kami.mall.entity.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author yangzi
 * @date 2021-07-13 3:19 PM
 */
@Component
public class SessionHolder {

    private static HttpSession session;

    @Autowired
    public SessionHolder(HttpSession httpSession) {
        session = httpSession;
    }

    public static UserBO getUserInfo() {
       return (UserBO) session.getAttribute(CommonConfig.LOGIN_USER);
    }
}
