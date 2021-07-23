package com.kami.mall.learn.strategy;

import org.springframework.stereotype.Service;

/**
 * @author yangzi
 * @date 2021-06-22 2:46 PM
 * 微信支付
 */
@Service("WechatPay")
public class WechatPay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("微信支付成功");
    }
}
