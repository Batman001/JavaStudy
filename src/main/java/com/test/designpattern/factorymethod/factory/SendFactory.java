package com.test.designpattern.factorymethod.factory;

/**
 * @author Batman create on 2019-04-22 15:02
 */
public class SendFactory {
    public Sender produce(String type){
        String mailType = "mail";
        String smsType = "sms";
        if(mailType.equals(type)){
            return new MailSender();
        }else if (smsType.equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请输入正确的类型！");
            return null;
        }
    }

}
