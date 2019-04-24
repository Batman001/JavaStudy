package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-23 16:32
 */
public class SendWeChatFactory implements Provider {
    @Override
    public Sender produce() {
        return new WeChatSender();
    }
}
