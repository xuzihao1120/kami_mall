package com.kami.mall.common.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    /**
     * 0-无异常
     * 1001-权限校验异常
     * 1002-数据库异常
     * 1003-Redis异常
     * 1004-代码异常
     * 1005-其他异常 
     * 1006-参数异常 
     */
    SUCCESS("0","无异常"),
    AUTH_EXCEPTION("1001","权限校验异常"),
    DB_EXCEPTION("1002","数据库异常"),
    REDIS_EXCEPTION("1003","Redis异常"),
    CODE_EXCEPTION("1004","代码异常"),
    OTHER_EXCEPTION("1005","其他异常"),
    PARAMS_EXCEPTION("1006","参数异常"),
    ;

    private String code;

    private String description;

    ErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
