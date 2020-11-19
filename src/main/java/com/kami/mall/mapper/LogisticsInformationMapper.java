package com.kami.mall.mapper;

import com.kami.mall.entity.DO.LogisticsInformation;

public interface LogisticsInformationMapper {
    int deleteByPrimaryKey(Long id);

    LogisticsInformation selectByPrimaryKey(Long id);
}