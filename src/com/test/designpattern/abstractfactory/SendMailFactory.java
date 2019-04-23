package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-22 15:20
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
