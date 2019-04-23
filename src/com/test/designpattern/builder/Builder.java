package com.test.designpattern.builder;

import com.test.designpattern.factorymethod.factory.MailSender;
import com.test.designpattern.factorymethod.factory.Sender;
import com.test.designpattern.factorymethod.factory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-04-22 16:41
 */
public class Builder {
    private List<Sender> list = new ArrayList<>();
    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }
    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }

    @Override
    public String toString() {
        return "Builder{" +
                "list=" + list +
                '}';
    }

    public List<Sender> getList() {
        return list;
    }
}
