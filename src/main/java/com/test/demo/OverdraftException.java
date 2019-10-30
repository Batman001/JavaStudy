package com.test.demo;

/**
 * Created by Batman on 2018/7/27.
 */
public class OverdraftException extends Throwable {
    public OverdraftException(){}
    public OverdraftException(String msg) {
        super(msg);
    }
}
