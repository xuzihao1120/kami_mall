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


import org.apache.commons.lang3.StringUtils;

/**
 * Created on 2017/03/10
 *
 * @author annpeter.it@gmail.com
 */
public class CommonException extends RuntimeException {

    protected String errMsg;
    protected String detailMsg;
    protected CommonErrorCode error;
    protected Object data;

    public CommonException(CommonErrorCode error) {
        super(error.getMsg());
        this.error = error;
        this.errMsg = error.getMsg();
    }

    public CommonException(CommonErrorCode error, String errMsg) {
        super(errMsg);
        this.error = error;
        this.errMsg = errMsg;
    }

    public CommonException(CommonErrorCode error, String errMsg, String detailMsg) {
        super(StringUtils.isEmpty(detailMsg) ? errMsg : detailMsg);
        this.error = error;
        this.errMsg = errMsg;
        this.detailMsg = detailMsg;
    }

    public CommonException(CommonErrorCode error, String errMsg, Throwable cause) {
        super(errMsg, cause);
        this.error = error;
        this.errMsg = errMsg;
    }

    public CommonException(CommonErrorCode error, String errMsg, String detailMsg, Throwable cause) {
        super(StringUtils.isEmpty(detailMsg) ? errMsg : detailMsg, cause);
        this.error = error;
        this.errMsg = errMsg;
        this.detailMsg = detailMsg;
    }

    public CommonException(CommonErrorCode error, Throwable cause) {
        super(error.getMsg(), cause);
        this.error = error;
        this.errMsg = error.getMsg();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public CommonErrorCode getError() {
        return error;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public Object getData() {
        return data;
    }

    public CommonException setData(Object data) {
        this.data = data;
        return this;
    }
}
