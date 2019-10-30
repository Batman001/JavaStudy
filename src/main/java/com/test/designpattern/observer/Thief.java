package com.test.designpattern.observer;

/**
 * @author Batman create on 2019-06-12 14:50
 * 监听器模式
 * 被监听对象
 */
public class Thief {

    private ThiefListener listener;

    public void registerListener(ThiefListener listener){
        this.listener = listener;
    }

    public void steal(){
        System.out.println("To Steal Money...");
        // 偷之前 先告诉警察
        if (listener != null) {
            Event event = new Event(this);

            // 喂，有胆开枪啊！
            listener.shot(event);
        }

    }
}
