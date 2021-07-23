package com.kami.mall.service;

import com.kami.mall.common.model.ResultModel;

/**
 * @author yangzi
 * @date 2021-06-23 10:21 AM
 * 会员管理Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    ResultModel generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    ResultModel verifyAuthCode(String telephone, String authCode);
}
