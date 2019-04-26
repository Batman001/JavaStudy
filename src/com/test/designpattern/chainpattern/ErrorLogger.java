package com.test.designpattern.chainpattern;

/**
 * @author Batman create on 2019-04-26 14:26
 */
public class ErrorLogger extends AbstractLogger {
    ErrorLogger(int level){
        this.level = level;
    }
    /**
     * 抽象类的抽象方法 write message
     *
     * @param message String 日志写入信息
     */
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
