package com.kami.mall.controller;

import com.kami.mall.common.enums.ErrorCodeEnum;
import com.lwx.exception.BizException;
import com.lwx.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger("BIZ");

	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String handleException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		HashMap<String,Object> msg=new HashMap();
		logger.error("服务调用失败::{}", exception);
		try {
			String errorCode = ErrorCodeEnum.OTHER_EXCEPTION.getCode();
			String message;
			if (exception instanceof BizException) {
				BizException bizException = (BizException) exception;
				errorCode = bizException.getErrorCode();
				message = bizException.getMessage();
                logger.error("failed to handle http request. errCode:{} ,errMessage:{} {}", errorCode, message, bizException);
			} else {
                logger.error("服务调用失败:{}", exception);
				message = "服务调用失败";
			}
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setStatus(200);
			msg.put("code",Integer.parseInt(StringUtils.isBlank(errorCode)?ErrorCodeEnum.OTHER_EXCEPTION.getCode():errorCode));
			msg.put("message", message);
			msg.put("uuid","");
			msg.put("result", 0);
		} catch (Exception e) {
			msg.put("code",Integer.parseInt(ErrorCodeEnum.OTHER_EXCEPTION.getCode()));
			msg.put("message", "服务调用失败");
			msg.put("result", 0);
            msg.put("uuid","");
			logger.error("服务调用失败::{}", e);
		}
		return JsonUtils.toJson(msg);
	}


}
