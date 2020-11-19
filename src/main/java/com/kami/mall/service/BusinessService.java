package com.kami.mall.service;

import com.kami.mall.entity.request.BusinessRequest;
import com.kami.mall.entity.response.vo.BusinessVO;

public interface BusinessService {

    BusinessVO selectByPrimaryKey(BusinessRequest request);

}
