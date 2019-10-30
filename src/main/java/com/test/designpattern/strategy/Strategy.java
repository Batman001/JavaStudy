package com.test.designpattern.strategy;

/**
 * @author Batman create on 2019-04-24 14:48
 */
public interface Strategy {
    /**
     * 对num1, num2进行计算 返回计算结果
     * @param num1 int a
     * @param num2 int b
     * @return int result
     */
    public int doOperation(int num1, int num2);
}
