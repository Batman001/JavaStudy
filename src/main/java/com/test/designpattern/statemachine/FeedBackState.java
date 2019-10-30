package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 12:14
 * 完结状态
 */
public class FeedBackState extends AbstractState {
    /**
     * 得到当前事件的状态
     *
     * @return String 当前状态
     */
    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }

}
