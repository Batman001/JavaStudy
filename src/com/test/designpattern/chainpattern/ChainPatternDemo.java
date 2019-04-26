package com.test.designpattern.chainpattern;

/**
 * @author Batman create on 2019-04-26 14:28
 * 责任链模式 为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。
 * 这种类型的设计模式属于行为型模式。
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLogger(){
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLogger();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information");

    }

}
