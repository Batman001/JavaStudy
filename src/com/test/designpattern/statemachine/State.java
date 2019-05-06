package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 12:04
 * 状态接口
 */
public interface State {
    /**
     * 电审
     * @param context 环境上下文
     */
    void checkEvent(Context context);

    /**
     * 电审失败
     * @param context 环境上下文
     */
    void checkFailEvent(Context context);

    /**
     * 定价发布
     * @param context 环境上下文
     */
    void makePriceEvent(Context context);

    /**
     * 接单
     * @param context 环境上下文
     */
    void acceptOrderEvent(Context context);

    /**
     * 无人接单失败
     * @param context 环境上下文
     */
    void notPersonAcceptEvent(Context context);

    /**
     * 付款
     * @param context 环境上下文
     */
    void payOrderEvent(Context context);

    /**
     * 接单有人支付失效
     * @param context 环境上下文
     */
    void orderFailureEvent(Context context);

    /**
     * 反馈
     * @param context 环境上下文
     */
    void feedBackEvent(Context context);

    /**
     * 得到当前事件的状态
     * @return String 当前状态
     */
    String getCurrentState();


}
