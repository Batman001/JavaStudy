package com.test.designpattern.adapter.classadapter;

/**
 * @author Batman create on 2019-05-13 09:11
 * 手机充电需要将220V的交流电转化为锂电池需要的5V的直流电 需要采用适配器实现
 */
public class AC220 {
    public int output220V(){
        int output = 220;
        return output;
    }
}
