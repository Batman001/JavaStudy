package com.test.designpattern.abstractfactory;

/**
 * @author Batman create on 2019-04-22 15:21
 */
public interface Provider {
    /**
     * 邮件和短信生产 sender接口方法
     * @return Sender
     */
    public Sender produce();
}
