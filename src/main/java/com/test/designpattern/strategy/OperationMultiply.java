package com.test.designpattern.strategy;

/**
 * @author Batman create on 2019-04-24 14:55
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
