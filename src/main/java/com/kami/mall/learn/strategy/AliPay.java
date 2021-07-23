package com.kami.mall.learn.strategy;

import org.springframework.stereotype.Service;

/**
 * @author yangzi
 * @date 2021-06-22 2:48 PM
 * 支付宝
 */
@Service("AliPay")
public class AliPay implements IPayment {
    @Override
    public PayResult pay(Order order) {
        return new PayResult("支付宝支付成功");
    }
}
