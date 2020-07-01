package com.aidansu.mall.core.constant;

/**
 * 接口常量
 *
 * @author aidan
 */
public interface ApisConstant {

    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 默认未授权消息
     */
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";
    /**
     * 登录失败
     */
    String LOGIN_FAILED = "登录失败";
    /**
     * 请先登录
     */
    String PLEASE_LOGIN_FIRST = "请先登录";
    /**
     * 流控/降级
     */
    String FLOW_CONTROL_DOWNGRADE = "流控/降级";
    /**
     * 用户名或密码错误
     */
    String USERNAME_OR_PASSWORD_ERROR = "用户名或密码错误";

}
