package com.company.caini.GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by Batman on 2018/11/1.
 */
public class MouseListenerTest {
    public static void main(String[] args) {
        final JFrame f = new JFrame("LOL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("/Users/Batman/Desktop/shana.png");
        l.setIcon(i);
        l.setBounds(375, 275,i.getIconWidth(), i.getIconHeight());
        f.add(l);

        l.addMouseListener(new MouseListener() {
            @Override
            // 点击鼠标
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            // 按下鼠标
            public void mousePressed(MouseEvent e) {

            }

            @Override
            // 释放鼠标
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            // 鼠标进入
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
                l.setLocation(x, y);

            }

            @Override
            // 鼠标退出
            public void mouseExited(MouseEvent e) {

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
