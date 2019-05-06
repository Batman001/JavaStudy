package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:45
 * 待付款状态
 */
public class NotPayState extends AbstractState {
    /**
     * 得到当前事件的状态
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.NOT_PAY.getValue();
    }

    /**
     * 付款
     * @param context
     */
    @Override
    public void payOrderEvent(Context context) {
        context.setState(new PaidState());
    }

    /**
     * 反馈
     * @param context
     */
    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }
}
