package com.kami.mall.mapper;

import com.kami.mall.entity.DO.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    Order selectByPrimaryKey(Long id);

    void addOrder(Order order);

    void updateOrder(Order order);
}