package com.test.designpattern.factorymethod.multiplefactory;

import com.test.designpattern.factorymethod.factory.Sender;

/**
 * @author Batman create on 2019-04-22 15:10
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }
}
