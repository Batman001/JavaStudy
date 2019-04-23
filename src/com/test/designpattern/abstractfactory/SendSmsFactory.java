package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-22 15:22
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
