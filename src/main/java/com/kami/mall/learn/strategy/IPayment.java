package com.kami.mall.learn.strategy;

/**
 * @author yangzi
 * @date 2021-06-22 2:34 PM
 * 支付接口，策略接口
 */
public interface IPayment {

    /**
     * 支付
     * @param order
     * @return
     */
    PayResult pay(Order order);
}
