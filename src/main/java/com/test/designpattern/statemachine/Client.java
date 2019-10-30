package com.test.designpattern.statemachine;

/**
 * @author Batman create on 2019-05-06 14:11
 * 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new PublishState());

        //publish --> not pay
        context.acceptOrderEvent(context);

        //not pay --> paid
        context.payOrderEvent(context);

        // 失败
        context.checkFailEvent(context);

    }
}

