package com.kami.mall.service.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author yangzi
 * @date 2021-06-23 1:46 PM
 * 订单超时取消并解锁库存的定时器
 */
@Component
public class OrderTimeOutCancelTask {

    private Logger logger = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        logger.info("取消订单，并根据编号释放库存");
    }

}
