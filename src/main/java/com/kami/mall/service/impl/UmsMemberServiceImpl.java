package com.kami.mall.service.impl;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.ResultModel;
import com.kami.mall.service.UmsMemberService;
import com.kami.mall.service.redis.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author yangzi
 * @date 2021-06-23 10:24 AM
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public ResultModel generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        return ResultModel.success(sb.toString(), "获取验证码成功");
    }

    /**
     * 对输入的验证码进行检验
     * @param telephone
     * @param authCode
     * @return
     */
    @Override
    public ResultModel verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return ResultModel.fail(CommonErrorCode.ERROR_AUTH, "请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return ResultModel.success(null, "验证码校验成功");
        } else {
            return ResultModel.fail(CommonErrorCode.ERROR_AUTH, "验证码不正确");
        }
    }
}
