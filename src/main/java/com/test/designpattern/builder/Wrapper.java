package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:24
 * 实现packing的接口的burger的包装纸类
 */
public class Wrapper implements Packing{
    /**
     * 食物包装的接口
     *
     * @return String
     */
    @Override
    public String pack() {
        return "Wrapper";
    }
}
