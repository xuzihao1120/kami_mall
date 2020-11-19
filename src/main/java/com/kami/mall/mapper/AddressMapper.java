package com.kami.mall.mapper;

import com.kami.mall.entity.DO.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Long id);

    Address selectByPrimaryKey(Long id);
}