package com.kami.mall.service.impl;

import com.kami.mall.entity.DO.Business;
import com.kami.mall.entity.request.BusinessRequest;
import com.kami.mall.entity.response.vo.BusinessVO;
import com.kami.mall.mapper.BusinessMapper;
import com.kami.mall.service.BusinessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Override
    public BusinessVO selectByPrimaryKey(BusinessRequest request) {
        Business business = businessMapper.selectByPrimaryKey(request.getId());
        BusinessVO businessVO = new BusinessVO();
        BeanUtils.copyProperties(business,businessVO);
        return businessVO;
    }
}
