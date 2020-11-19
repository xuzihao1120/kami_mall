package com.kami.mall.entity.response;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 *  响应数据（可选返回值）
 */
@Getter
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataResponse<T> extends CommonResponse {
	@ApiModelProperty(name = "data" ,value = "响应数据")
    private T data;

    public DataResponse() {
    }

	@Override
	public DataResponse<T> success() {
		this.setCode(CommonResponse.SUCCEED);
		return this;
	}

	@Override
	public DataResponse<T> fail(Integer errorCode, String message) {
		this.setCode(errorCode);
		this.setMessage(message);
		return this;
	}

	public DataResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
}
