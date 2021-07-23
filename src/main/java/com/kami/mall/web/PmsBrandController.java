package com.kami.mall.web;

import com.kami.mall.common.model.ResultModel;
import com.kami.mall.entity.vo.PmsBrandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzi
 * @date 2021-06-24 2:30 PM
 */
@RestController
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {

    @ApiOperation(value = "添加品牌")
    @PostMapping(value = "/add")
    public ResultModel add(@Validated  @RequestBody PmsBrandVO pmsBrandVO, BindingResult bindingResult) {
        return ResultModel.success("试参数校验方式");
    }
}
