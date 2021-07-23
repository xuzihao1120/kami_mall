package com.kami.mall.service;

import com.kami.mall.entity.DO.Order;

/**
 * @author yangzi
 * @date 2021-06-22 10:22 AM
 */
public interface OrderService {

    Order selectOrder(Integer id);

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Integer id);

}
