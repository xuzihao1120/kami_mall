package com.kami.mall.web;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

/**
 * @author yangzi
 * @date 2021-06-23 10:13 AM
 * 会员登录注册管理
 */
@RestController
@Api(tags = "UmsMemebrController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public ResultModel getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }


    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public ResultModel updatePassword(@RequestParam String telephone, @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
