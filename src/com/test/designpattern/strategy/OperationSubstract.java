package com.test.designpattern.strategy;

/**
 * @author Batman create on 2019-04-24 14:55
 */
public class OperationSubstract implements Strategy {
    /**
     * 对num1, num2进行相减计算 返回计算结果
     *
     * @param num1 int a
     * @param num2 int b
     * @return a-b
     */
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
