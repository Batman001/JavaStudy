package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:40
 * 订单生成状态
 */
public class GenerateState extends AbstractState {
    /**
     * 电审
     * 审核通过后 状态变更为已审核
     * @param context
     */
    @Override
    public void checkEvent(Context context) {
        context.setState(new ReviewState());
    }

    /**
     * 电审失败
     * 电审失败后 状态变更为完结状态
     * @param context
     */
    @Override
    public void checkFailEvent(Context context) {
        context.setState(new FeedBackState());
    }

    /**
     * 得到当前事件的状态
     *
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.GENERATE.getValue();
    }
}
