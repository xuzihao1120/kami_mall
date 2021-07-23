package com.kami.mall.mq;

import com.kami.mall.service.mq.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author yangzi
 * @date 2021-06-23 4:25 PM
 * 取消订单消息的处理者
 */
//@Component
//@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private static Logger logger = LoggerFactory.getLogger(CancelOrderReceiver.class);

//    @Autowired
    private OmsPortalOrderService portalOrderService;

//    @RabbitHandler
    public void handle(Long orderId) {
        logger.info("receiver delay message orderId: {}", orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
