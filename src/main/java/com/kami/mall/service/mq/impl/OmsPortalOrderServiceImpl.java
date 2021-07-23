package com.kami.mall.service.mq.impl;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.entity.DO.Order;
import com.kami.mall.mq.CancelOrderReceiver;
import com.kami.mall.mq.CancelOrderSender;
import com.kami.mall.service.mq.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangzi
 * @date 2021-06-23 4:47 PM
 * 前台订单管理
 */
//@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger logger = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

//    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public ResultModel generateOrder(Order order) {
        // todo 执行一系列下单操作
        logger.info("process generateOrder");
        // 下单完成后开启一个延迟消息，用于当用户没有付款时取消订单 (orderId应该在下单后生成)
        sendDelayMessageCancelOrder(11L);
        return ResultModel.success(null, "下单成功");
    }

    private void sendDelayMessageCancelOrder(long orderId) {
        // 获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        // 发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    @Override
    public void cancelOrder(Long orderId) {
        // todo 执行一系列取消订单操作
        System.out.println("已经取消" + orderId  + "订单");
        logger.info("process cancelOrder orderId: {}", orderId);
    }
}
