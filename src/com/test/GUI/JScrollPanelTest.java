package com.company.caini.GUI;

import javax.swing.*;

/**
 * Created by Batman on 2018/11/5.
 * 滚动条的面板
 */
public class JScrollPanelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(300, 400);
        f.setLocation(200, 200);
        f.setLayout(null);

        // 准备一个文本域
        JTextArea ta = new JTextArea();
        for(int i=0;i<1000;i++){
            ta.append(String.valueOf(i) + " ");
        }

        // 自动换行
        ta.setLineWrap(true);

        JScrollPane sp = new JScrollPane(ta);
        // 把sp当作ContentPane
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
