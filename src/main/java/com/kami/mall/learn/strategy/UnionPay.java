package com.kami.mall.learn.strategy;

import org.springframework.stereotype.Service;

/**
 * @author yangzi
 * @date 2021-06-22 2:49 PM
 * 云闪付
 */
@Service("UnionPay")
public class UnionPay implements IPayment {
    @Override
    public PayResult pay(Order order) {
        return new PayResult("云闪付支付成功");
    }
}
