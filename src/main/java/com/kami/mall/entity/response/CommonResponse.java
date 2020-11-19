package com.kami.mall.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.kami.mall.common.enums.ErrorCodeEnum;

import java.io.Serializable;

/**
 * 接口基础类响应数据（必须返回的值）
 */
@Data
@ApiModel(description = "接口响应数据")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse implements Serializable {
	public static final Integer SUCCEED = 0;

	public static final Integer FAILURE = Integer.parseInt(ErrorCodeEnum.CODE_EXCEPTION.getCode());

	public static final Integer SUCCEED_RESULT = 1;

	public static final Integer FAILURE_RESULT = 0;

	@ApiModelProperty(name = "code",value = "异常编码，正常为 0")
	private Integer code;

	@ApiModelProperty(name = "result",value = "1-成功，0-失败")
	private Integer result;

	@ApiModelProperty(name = "message",value = "返回信息")
	private String message="OK";

	@ApiModelProperty(name = "uuid",value = "日志id")
	private String uuid;


	public CommonResponse() {
		this(SUCCEED);
	}

	public CommonResponse(Integer code) {
		this.code = code;
		this.setResult(SUCCEED_RESULT);
	}

	public CommonResponse success() {
		this.setCode(SUCCEED);
		this.setResult(SUCCEED_RESULT);
		return this;
	}
	public CommonResponse fail() {
		this.setCode(FAILURE);
		this.setResult(FAILURE_RESULT);
		this.setMessage("请求失败");
		return this;
	}

	public CommonResponse fail(Integer code, String message) {
		this.setCode(code);
		this.setResult(FAILURE_RESULT);
		this.setMessage(message);
		return this;
	}

}
