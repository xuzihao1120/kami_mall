package com.kami.mall.web;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.entity.DO.Order;
import com.kami.mall.entity.DO.User;
import com.kami.mall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangzi
 * @date 2021-06-22 10:16 AM
 */
@Api(tags = "OrderController", description = "商品订单管理")
@RestController
@RequestMapping("/order")
public class UserController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private User user;

    @ApiOperation("获取订单")
    @GetMapping("/selectOrder/{uname}")
    public ResultModel selectOrder(@PathVariable("uname") String name, @RequestParam Integer id) {
        System.out.println(name);
        Order order = orderService.selectOrder(id);
        return ResultModel.success(order, "查询成功");
    }

    @ApiOperation("添加订单")
    @PostMapping("/addOrder")
    public ResultModel addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResultModel.success("添加成功");
    }

    @ApiOperation("更新指定订单")
    @PostMapping("/updateOrder")
    public ResultModel updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return ResultModel.success("修改成功");
    }

    @ApiOperation("删除指定订单")
    @GetMapping("/deleteOrder")
    public ResultModel deleteOrder(@RequestParam Integer id) {
        orderService.deleteOrder(id);
        return ResultModel.success("删除成功");
    }

    @ApiOperation("测试@propertySource注解的作用")
    @GetMapping("/userInfo")
    public ResultModel userInfo() {
        System.out.println(user);
        return ResultModel.success(user, "获取成功");
    }

}
