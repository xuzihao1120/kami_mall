package com.kami.mall.mapper;

import com.kami.mall.entity.DO.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    Goods selectByPrimaryKey(Long id);
}