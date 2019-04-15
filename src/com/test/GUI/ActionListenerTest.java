package com.test.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Batman on 2018/10/30.
 * @author Batman
 * 创建一个匿名类实现ActionListener接口,当按钮被点击时,actionPerformed方法就会被调用
 */
public class ActionListenerTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("/Users/Batman/Desktop/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        // 给按钮增加监听功能
        b.addActionListener(new java.awt.event.ActionListener() {
            // 当按钮被点击时,就会触发ActionEvent时间
            // actionPerformed方法就会被执行
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);

            }
        });
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

    }
}
