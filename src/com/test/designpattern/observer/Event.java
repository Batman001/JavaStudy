package com.test.designpattern.observer;

/**
 * @author Batman create on 2019-06-12 14:51
 * 包装后的被监听对象
 */
public class Event {

    private Thief thief;

    public Event(){}

    public Event(Thief thief){
        this.thief = thief;
    }

    public void setThief(Thief thief) {
        this.thief = thief;
    }

    public Thief getThief() {
        return thief;
    }
}
