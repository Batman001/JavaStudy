package com.test.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2019/1/3.
 * @author Batman
 */


public class InitialThread {
    public static void main(String[] args) {
        new TestFrame().setVisible(true);
        /**
         * 事件调度线程
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestFrame().setVisible(true);
            }
        });


        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("/Users/Batman/Desktop/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(true);
                System.out.println("当前使用的是事件调度线程: " +
                SwingUtilities.isEventDispatchThread());
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    static class TestFrame extends JFrame {
        public TestFrame(){
            setTitle("LoL");
            setSize(400, 300);
            setLocation(200, 200);
            setLayout(null);
            JButton b = new JButton("一秒秒掉对方基地");
            b.setBounds(50, 50, 280, 30);
            add(b);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            System.out.println("当前线程是否是 事件调度线程: "
                    +SwingUtilities.isEventDispatchThread());
        }


    }
}
