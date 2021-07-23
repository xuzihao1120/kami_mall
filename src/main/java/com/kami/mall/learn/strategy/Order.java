package com.kami.mall.learn.strategy;

import lombok.Data;

/**
 * @author yangzi
 * @date 2021-06-22 2:43 PM
 * 订单信息
 */
@Data
public class Order {

    /**
     * 金额
     */
    private int amount;

    /**
     * 支付类型
     */
    private String paymentType;
}
