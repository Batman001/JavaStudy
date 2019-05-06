package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:53
 */
public class PaidState extends AbstractState {
    /**
     * 得到当前事件的状态
     *
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.PAID.getValue();
    }

    /**
     * 反馈
     * @param context 环境上下文
     */
    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());

    }
}
