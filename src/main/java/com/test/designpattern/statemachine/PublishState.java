package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:55
 */
public class PublishState extends AbstractState {
    /**
     * 得到当前事件的状态
     *
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.PUBLISHED.getValue();
    }

    /**
     * 接单
     * @param context 环境上下文
     */
    @Override
    public void acceptOrderEvent(Context context) {
        context.setState(new NotPayState());
    }

    /**
     * 无人接单失败
     * @param context 环境上下文
     */
    @Override
    public void notPersonAcceptEvent(Context context) {
        context.setState(new FeedBackState());
    }
}
