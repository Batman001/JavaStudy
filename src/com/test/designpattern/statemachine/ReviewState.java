package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 13:58
 */
public class ReviewState extends AbstractState {
    /**
     * 得到当前事件的状态
     *
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.REVIEWED.getValue();
    }

    /**
     * 定价发布
     *
     * @param context
     */
    @Override
    public void makePriceEvent(Context context) {
        context.setState(new PublishState());
    }
}
