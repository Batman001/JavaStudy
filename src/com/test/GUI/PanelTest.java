package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/5.
 * 创建一个水平JSplitPane，左边是pLeft,右边是pRight
 */
public class PanelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);

        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);
        pLeft.setBackground(Color.RED);
        pLeft.setLayout(new FlowLayout());
        JButton b1 = new JButton("Hero1");
        JButton b2 = new JButton("Hero2");
        JButton b3 = new JButton("Hero3");
        pLeft.add(b1); pLeft.add(b2); pLeft.add(b3);


        JPanel pRight = new JPanel();
        pRight.setBounds(10, 150, 300, 60);
        pRight.setLayout(new FlowLayout());
        pRight.setBackground(Color.CYAN);
        JButton b4 = new JButton("Hero4");
        JButton b5 = new JButton("Hero5");
        JButton b6 = new JButton("Hero6");
        pRight.add(b4); pRight.add(b5); pRight.add(b6);

        // 创建一个水平的JSplitPane,左边是pLeft,右边是pRight
        JSplitPane sp = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // 设置分隔线条的位置
        sp.setDividerLocation(80);

        // 把sp当做ContentPane
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
   }
}
