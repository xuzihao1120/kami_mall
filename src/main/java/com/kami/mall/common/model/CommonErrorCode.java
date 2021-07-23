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

/**
 * Created by louie on 16-11-16.
 */
public enum CommonErrorCode {

    SUCCESS(200, "执行成功"),
    ALIYUN_API_ERROR(300, "调用阿里云API异常"),
    UPLOAD_OSS_ERROR(300, "上传OSS失败"),
    AMAP_API_ERROR(301, "调用高德API异常"),
    BOLAI_API_ERROR(302, "调用伯来API异常"),
    ALIYUN_IOT_API_ERROR(303, "调用阿里云IOT的API异常"),
    ALIYUN_DYVM_API_ERROR(304, "调用阿里云DYVM的API异常")

    //400 403 前端会强制做跳转，这两个返回码不能修改
,   USER_NOT_LOGIN(400, "用户未登录"),
    VALIDATE_ERROR(401,"校验数据错误"),
    NOT_EXSITS(404,"不存在"),
    USER_LOGIN_AUTH_FAILED(401,"账号或密码错误"),
    ACCOUNT_NOT_EXSITS(400,"账号不存在"),
    NO_FREE_VOIP_ACCOUNT(404, "不存在空闲的VoIP账号"),
    VOIP_ACCOUNT_STATUS_ERROR(405, "VoIP账号状态异常"),

    HAS_EXSITS(405, "已经存在"),
    FORBIDDEN(403, "权限不足"),
    RESOURCE_NOT_FOUND(404, "资源未找到"),
    RESOURCE_CONFLICT(409, "资源冲突"),
    REQUEST_PARAM_ERROR(412, "参数错误"),
    PRECONDITION_FAILED(428, "要求先决条件"),
    PUBLIC_WECHAT_NOT_LOGIN(406, "请在微信公众号中打开链接"),
    DATE_ERROR(407, "日期选择不对"),
    TIME_ERROR(408, "时间选择不对"),
    NOT_SUPPORT(409, "不支持"),
    NO_EMPLOYEE_ROLE(410, "您还没认证成为员工,无权限操作"),
    RE_LOGIN(400, "登录已过期,请重新登录"),
    ACCOUNT_OVERDUE(411, "账号试用期已经结束, 请联系商务"),
    ERROR_NO_FACE(412, "人脸照片不清晰"),
    ERROR_AUTH(413, "没有权限"),
    NO_PERMISSION(414, "没有该权限点，请联系上级管理员添加权限"),

    TOKEN_EXPIRESIN(416, "免登已经过期,请重新获取token"),
    UN_OPEN_STORE(417, "未开通,无法获取免登token"),
    SMS_ERROR(418, "请稍后重试"),
    PARAM_ERROR(419, "参数校验不通过"),
    CS_STAFF_IM_REQUEST_ERROR(420, "人工坐席IM请求失败"),

    UNKNOWN_ERROR(500,"未知错误"),
    SERVER_POWER_LESS(501, "服务器无法完成该请求"),
    SERIALIZATION_ERROR(501, "服务器无法完成该请求"),
    RETRY_ERROR(502, "服务器重试出错"),

    OPTIMISTIC_LOCK_VERSION_ERROR(600, "更新失败,请重试"),
    ALIYUN_NLS_MANAGE_ERROR(601, "阿里云nls管理出错"),

    /**
     * 阿里云特殊处理code
     */
    ALIYUN_HOTWORD_VOCABULARY_TOO_MANY(901, "阿里云热词库超限"),

    /**
     * 微信绑定，登录专用状态码
     */
    WECHAT_QRCODE_DEFAULT(420, "无结果,请重试"),
    WECHAT_QRCODE_OVERTIME(421, "二维码已失效，请刷新二维码"),
    WECHAT_QRCODE_FAIL(422, "失败"),

    /**
     * 小程序状态码
     */
    WECHAT_MINI_PROGRAM_FAIL(430,"微信接口服务验证失败"),
    WECHAT_MINI_UNION_ACCOUNT_FAIL(431,"unionId未找到对应的绑定账号"),
    WECHAT_MINI_TOKEN_FAIL(432,"token验证失效"),

    /**
     * 需要特殊处理的code
     */
    HAS_AUTH_ERROR(600,"未知错误"),
    MOBILE_SEND_ERR(700, "短信发送失败"),
    TODAY_FREE_TRY_OUT_ALL_USED(701, "今日的免费试用次数已用完"),
    OPEN_DOOR_PERMISSION_DENIED(800, "开门权限不足"),
    PHONE_DEBT(801, "线路欠费"),
    UP_AVERAGE(802, "任务高于平均值"),
    SMS_DEBT(803, "短信欠费"),
    NOT_EMPLOYEE(900, "未认证为员工"),
    AI_SEAT_STOCK_SHORTAGE(777, "AI坐席库存不足"),
    VOIP_ACCOUNT_CONFLICT(701, "VoIP账号重复"),
    DUBBO_ERROR(602, "BYAI远程服务异常"),

    /**
     * ai助理
     */
    DUPLICATION_PRODUCT(920, "产品助理已存在"),
    DUPLICATION_OFFICIAL_WEBSITE(921, "公司助理已存在"),

    KNOWLEDGE_PUBLISH_ERROR(1000,"模型发布失败");


    private Integer code;
    private String msg;

    CommonErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
