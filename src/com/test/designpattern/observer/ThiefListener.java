package com.test.designpattern.observer;

/**
 * @author Batman create on 2019-06-12 14:51
 * 监听器接口
 */
public interface ThiefListener {
    /**
     * 监听器的行动方法
     * @param event 包装后的被监听对象(装了监听器的Thief对象)
     */
    void shot(Event event);

}
