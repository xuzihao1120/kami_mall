package com.kami.mall.web;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.entity.DO.Order;
import com.kami.mall.service.mq.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzi
 * @date 2021-06-23 4:59 PM
 * 订单管理
 */
@RestController
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
//    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    public ResultModel generateOrder(@RequestBody Order order) {
        return portalOrderService.generateOrder(order);
    }
}
