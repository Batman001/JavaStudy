package com.test.designpattern.chainpattern;

/**
 * @author Batman create on 2019-04-26 14:12
 * 抽象记录器类
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    /** 责任链中的下一个元素 */
    private AbstractLogger nextLogger;

    void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(int level, String message){
        if(this.level <= level) {
            write(message);
        }
        if(nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * 抽象类的抽象方法 write message
     * @param message String 日志写入信息
     */
    abstract protected void write(String message);
}
