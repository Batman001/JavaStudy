package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-23 16:31
 */
public class WeChatSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is weChat send message!");
    }
}
