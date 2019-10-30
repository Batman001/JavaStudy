package com.test.designpattern.factorymethod.factory;

/**
 * @author Batman create on 2019-04-22 15:01
 */
public class MailSender implements Sender{
    @Override
    public void send(){
        System.out.println("This is mail sender!");
    }
}
