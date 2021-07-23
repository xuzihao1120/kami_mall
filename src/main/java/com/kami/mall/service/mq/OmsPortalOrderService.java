package com.kami.mall.service.mq;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.entity.DO.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangzi
 * @date 2021-06-23 4:37 PM
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     * @param order
     * @return
     */
    @Transactional
    ResultModel generateOrder(Order order);


    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}
