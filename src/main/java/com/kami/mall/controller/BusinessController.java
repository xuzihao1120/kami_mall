package com.kami.mall.controller;

import com.kami.mall.entity.request.BusinessRequest;
import com.kami.mall.entity.response.DataResponse;
import com.kami.mall.service.BusinessService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther xuzihao
 * @Date 2020-11-19 13:01
 */
@RestController
@RequestMapping("/api/kami/mall")
public class BusinessController extends BaseController {

    @Autowired
    BusinessService businessService;

    @PostMapping("/selectBusiness")
    @ApiOperation(value = "查询商家", notes = "查询商家")
    @ApiImplicitParams(@ApiImplicitParam(name = "request", value = "请求实体", required = true, dataType = "BusinessRequest", paramType = "body"))
    public DataResponse selectBusiness(@RequestBody BusinessRequest request) {

        return new DataResponse().setData(businessService.selectByPrimaryKey(request)).success();
    }

}
