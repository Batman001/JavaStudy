package com.test.designpattern.factorymethod.staticfactory;

import com.test.designpattern.factorymethod.factory.MailSender;
import com.test.designpattern.factorymethod.factory.Sender;
import com.test.designpattern.factorymethod.factory.SmsSender;

/**
 * @author Batman create on 2019-04-22 15:13
 * 静态工厂模式 不需要创建实例 直接调用即可
 */
public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
