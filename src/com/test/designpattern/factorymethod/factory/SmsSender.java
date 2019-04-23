package com.test.designpattern.factorymethod.factory;

/**
 * @author Batman create on 2019-04-22 15:02
 */
public class SmsSender implements Sender {
    @Override
    public void send(){
        System.out.println("This is sms sender!");
    }
}
