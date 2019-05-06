package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:49
 * 环境上下文
 */
public class Context extends AbstractState {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 审核
     * @param context 环境上下文
     */
    @Override
    public void checkEvent(Context context) {
        state.checkEvent(this);
        getCurrentState();
    }

    /**
     * 审核失败
     * @param context 环境上下文
     */
    @Override
    public void checkFailEvent(Context context) {
        state.checkFailEvent(this);
        getCurrentState();
    }

    /**
     * 定价发布
     * @param context 环境上下文
     */
    @Override
    public void makePriceEvent(Context context) {
        state.makePriceEvent(this);
        getCurrentState();
    }

    /**
     * 接单
     * @param context 环境上下文
     */
    @Override
    public void acceptOrderEvent(Context context) {
        state.acceptOrderEvent(this);
        getCurrentState();
    }

    /**
     * 无人接单失败
     * @param context 环境上下文
     */
    @Override
    public void notPersonAcceptEvent(Context context) {
        state.notPersonAcceptEvent(this);
        getCurrentState();
    }

    /**
     * 付款
     * @param context 环境上下文
     */
    @Override
    public void payOrderEvent(Context context) {
        state.payOrderEvent(this);
        getCurrentState();
    }

    /**
     * 接单有人支付失效
     * @param context 环境上下文
     */
    @Override
    public void orderFailureEvent(Context context) {
        state.orderFailureEvent(this);
        getCurrentState();
    }

    /**
     * 反馈
     * @param context 环境上下文
     */
    @Override
    public void feedBackEvent(Context context) {
        state.feedBackEvent(this);
        getCurrentState();
    }

    /**
     * 得到当前事件的状态
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        System.out.println("当前状态： " + state.getCurrentState());
        return state.getCurrentState();
    }
}
