package com.kami.mall.learn.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzi
 * @date 2021-06-22 2:52 PM
 * 支付服务
 */
@RestController
public class PayService {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/pay")
    public PayResult pay(@RequestParam("amount") int amount, @RequestParam("paymentType") String paymentType) {
        Order order = new Order();
        order.setAmount(amount);
        order.setPaymentType(paymentType);

        IPayment payment = applicationContext.getBean(order.getPaymentType(), IPayment.class);
        PayResult payResult = payment.pay(order);
        return payResult;
    }

}
