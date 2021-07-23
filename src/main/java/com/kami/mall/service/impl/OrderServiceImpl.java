package com.kami.mall.service.impl;

import com.kami.mall.entity.DO.Order;
import com.kami.mall.mapper.OrderMapper;
import com.kami.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangzi
 * @date 2021-06-22 10:25 AM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectOrder(Integer id) {
        return orderMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMapper.deleteByPrimaryKey(Long.valueOf(id));
    }


}


