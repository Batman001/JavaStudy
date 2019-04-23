package com.test.designpattern.factorymethod.factory;

/**
 * @author Batman create on 2019-04-22 15:06
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sf = new SendFactory();
        Sender sender = sf.produce("mail");
        sender.send();
    }
}
