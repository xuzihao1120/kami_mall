package com.kami.mall.mapper;

import com.kami.mall.entity.DO.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BusinessMapper {
    int deleteByPrimaryKey(Long id);

    Business selectByPrimaryKey(@Param("id") Long id);
}