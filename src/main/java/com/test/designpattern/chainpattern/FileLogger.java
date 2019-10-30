package com.test.designpattern.chainpattern;

/**
 * @author Batman create on 2019-04-26 14:27
 */
public class FileLogger extends AbstractLogger{

    FileLogger(int level){
        this.level = level;
    }

    /**
     * 抽象类的抽象方法 write message
     *
     * @param message String 日志写入信息
     */
    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);

    }
}
