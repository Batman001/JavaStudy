package com.test.designpattern.proxy;

/**
 * @author Batman create on 2019-04-25 14:59
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘中加载
        image.display();
        System.out.println(" ");

        // 图像无法从磁盘中加载
        image.display();

    }
}
