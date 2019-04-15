package com.test.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/5.
 * 分页按钮面板
 */
public class TabbedPanelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(300, 400);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 300, 60);
        p1.setBackground(Color.RED);
        p1.setLayout(new FlowLayout());
        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        JPanel p2 = new JPanel();
        JButton b4 = new JButton("英雄4");
        JButton b5 = new JButton("英雄5");
        JButton b6 = new JButton("英雄6");

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);

        p2.setBackground(Color.BLUE);
        p2.setBounds(10, 150, 300, 60);


        JTabbedPane tp = new JTabbedPane();
        tp.add(p1);
        tp.add(p2);

        // 设置tab的标题
        tp.setTitleAt(0, "红色的Tab");
        tp.setTitleAt(1, "蓝色的Tab");

        ImageIcon i = new ImageIcon("/Users/Batman/Desktop/shana.png");
        tp.setIconAt(0, i);
        tp.setIconAt(1, i);

        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
