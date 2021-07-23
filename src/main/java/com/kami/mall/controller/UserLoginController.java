package com.kami.mall.controller;

import com.kami.mall.annotations.AuthorityPoint;
import com.kami.mall.java.comons.Utils.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzi
 * @date 2021-07-13 3:40 PM
 */
@RestController
@RequestMapping("/crm/user")
public class UserLoginController {

    @GetMapping("/login")
    @AuthorityPoint(AccessPoint = {"A", "B", "C", "G", "T"})
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParams(@ApiImplicitParam(name = "request", value = "请求实体", required = true, dataType = "BusinessRequest", paramType = "body"))
    public void login() {
        System.out.println("==========================CRM登录成功========================");
    }





}
