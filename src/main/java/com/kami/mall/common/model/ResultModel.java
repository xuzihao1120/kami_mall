/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.kami.mall.common.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

import static com.kami.mall.common.model.CommonErrorCode.SUCCESS;


/**
 * ResultModel 返回结果类
 *
 * Created by tianjin.lp on 16/8/31.
 */
public class ResultModel<T>  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = SUCCESS.getCode();
    private T data;
    private String resultMsg = SUCCESS.getMsg();
    private String errorStackTrace;
    private String requestId;

    private static ResultModel SUCCESS_RESULT_MODEL = ResultModel.success(null);

    public static ResultModel success() {

        return SUCCESS_RESULT_MODEL;
    }

    @JsonIgnore
    public  boolean isSuccess(){
        return code == SUCCESS.getCode();
    }

    public static <T> ResultModel<T> success(T data) {
        return success(data, SUCCESS.getMsg());
    }

    public static <T> ResultModel<T> success(T data, String msg) {
        return new ResultModel<>(SUCCESS.getCode(), data, msg, null);
    }

    public static <T> ResultModel<T> fail(CommonException ex) {
        String resultMsg = ex.getError().getMsg();
        if (StringUtils.isNotEmpty(ex.getErrMsg())) {
            resultMsg = ex.getErrMsg();
        }
        return new ResultModel<>(ex.getError().getCode(), null, resultMsg, ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonException ex, T data) {
        String resultMsg = ex.getError().getMsg();
        if (StringUtils.isNotEmpty(ex.getErrMsg())) {
            resultMsg = ex.getErrMsg();
        }
        return new ResultModel<>(ex.getError().getCode(), data, resultMsg, ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error) {
        return new ResultModel<>(error.getCode(), null, error.getMsg(), null);
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, String msg) {
        return new ResultModel<>(error.getCode(), null, msg, null);
    }

    public static <T> ResultModel<T> fail(int error, T data, String msg) {
        return new ResultModel<>(error, data, msg, null);
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, Throwable ex) {
        return new ResultModel<>(error.getCode(), null, error.getMsg(), ex.getMessage());
    }

    public static <T> ResultModel<T> fail(CommonErrorCode error, String msg, Throwable ex) {
        return new ResultModel<>(error.getCode(), null, msg, ex.getMessage());
    }

    public ResultModel() {
    }

    public ResultModel(int code, T data, String resultMsg, String errorStackTrace) {
        this.code = code;
        this.data = data;
        this.resultMsg = resultMsg;
        this.errorStackTrace = errorStackTrace;
    }

    public int getCode() {
        return code;
    }

    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public T getData() {
        return data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }
}
