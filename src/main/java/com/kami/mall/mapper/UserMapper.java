package com.kami.mall.mapper;

import com.kami.mall.entity.DO.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    User selectByPrimaryKey(Long id);
}