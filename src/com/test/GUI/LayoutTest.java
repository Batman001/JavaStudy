package com.test.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/1.
 * 绝对定位就是指不适用布局器,组件的位置和大小需要单独指定
 * FlowLayout顺序布局器,容器上组件水平摆放,加入到容器中即可,不需要指定大小和位置
 * BorderLayout组件按照 上北 下南 左西 右东 中 的顺序摆放
 */
public class LayoutTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
//        // 设置布局器为null,进行绝对定位,容器上的组件需要指定位置和大小
//        JButton b1 = new JButton("英雄1");
//        // 指定位置和大小
//        b1.setBounds(50, 50, 80, 30);
//
//        // 设置布局器为null,进行绝对定位,容器上的组件需要指定位置和大小
//        JButton b2 = new JButton("英雄2");
//        // 指定位置和大小
//        b2.setBounds(150, 50, 80, 30);
//
//        // 设置布局器为null,进行绝对定位,容器上的组件需要指定位置和大小
//        JButton b3 = new JButton("英雄3");
//        // 指定位置和大小
//        b3.setBounds(250, 50, 80, 30);
//
//        f.add(b1);
//        f.add(b2);
//        f.add(b3);
//
//
//        JButton b4 = new JButton("英雄4");
//
//        // b4没有指定位置和大小,不会出现在容器上
//        f.add(b4);


//        // 设置布局器为FlowLayerout
//        // 容器上组件水平摆放
//        f.setLayout(new FlowLayout());
//        JButton b1 = new JButton("Hero1");
//        JButton b2 = new JButton("Hero2");
//        JButton b3 = new JButton("Hero3");
//        JButton b4 = new JButton("Hero4");
//
//        f.add(b1);
//        f.add(b2);
//        f.add(b3);
//        f.add(b4);

//        // 设置布局方式为BorderLayout
//        f.setLayout(new BorderLayout());
//        JButton b1 = new JButton("洪七公");
//        JButton b2 = new JButton("段王爷");
//        JButton b3 = new JButton("欧阳锋");
//        JButton b4 = new JButton("黄老邪");
//        JButton b5 = new JButton("周伯通");
//
//        // 加入到容器中时 需要指定位置
//        f.add(b1, BorderLayout.NORTH);
//        f.add(b2, BorderLayout.SOUTH);
//        f.add(b3, BorderLayout.WEST);
//        f.add(b4, BorderLayout.EAST);
//        f.add(b5, BorderLayout.CENTER);

        // 设置布局方式为网格布局器
        f.setLayout(new GridLayout( 3, 2,20,20));

        JButton b1 = new JButton("洪七公");
        JButton b2 = new JButton("段王爷");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄老邪");
        JButton b5 = new JButton("周伯通");

        f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);


//        // 使用布局器也可以对布局器建议组件显示的大小
//
//        f.setLayout(new FlowLayout());
//        JButton b1 = new JButton("Hero1");
//        JButton b2 = new JButton("Hero2");
//        JButton b3 = new JButton("Hero3");
//
//        b3.setPreferredSize(new Dimension(180, 40));
//        f.add(b1);f.add(b2);f.add(b3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
}
