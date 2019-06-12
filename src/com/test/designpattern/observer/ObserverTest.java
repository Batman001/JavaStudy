package com.test.designpattern.observer;

/**
 * @author Batman create on 2019-06-12 14:56
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 被监听对象
        Thief thief = new Thief();

        // 监听器 直接new一个接口的匿名的对象
        ThiefListener listener = new ThiefListener() {
            @Override
            public void shot(Event event) {
                System.out.println("我开枪啦。。。。啪啪啪!!!");
            }
        };

        // 注册监听
        thief.registerListener(listener);

        // 特定行为 触发监听器 内部调用listener.shot()方法
        thief.steal();
    }
}
