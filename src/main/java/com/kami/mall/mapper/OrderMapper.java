package com.kami.mall.mapper;

import com.kami.mall.entity.DO.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    Order selectByPrimaryKey(Long id);
}