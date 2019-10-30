package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-22 15:19
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}
