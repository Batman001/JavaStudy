package com.test.designpattern.factorymethod.staticfactory;

import com.test.designpattern.factorymethod.factory.Sender;

/**
 * @author Batman create on 2019-04-22 15:14
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }
}
