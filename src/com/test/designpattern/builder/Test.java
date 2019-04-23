package com.test.designpattern.builder;

import com.test.designpattern.factorymethod.factory.Sender;

/**
 * @author Batman create on 2019-04-22 16:45
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
        for(Sender item:builder.getList()){
            item.send();
        }


    }
}
