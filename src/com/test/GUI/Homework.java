package com.company.caini.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2018/11/1.
 * 首先设计一个JFrame,上面有一个按钮,文字是"打开一个模态窗口"
 * 点击该按钮后,随即打开一个模态窗口
 * 这个模态窗口中有一个按钮,文本是"锁定大小",点击后,这个模态窗口的大小就被锁住,不能改变.再次点击,就恢复能够改变大小
 */
public class Homework {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(200, 200);
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(50, 50, 280, 30);

        // 根据外部窗体实例化JDialog
        b.addActionListener(new ActionListener() {
            JDialog d = new JDialog(f,"这是一个模态窗口");
            JButton button = new JButton("解锁按钮");
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setModal(true);
                d.add(button);
                button.setBounds(50, 50, 280, 30);
                button.addActionListener(new ActionListener() {
                    boolean flag = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 如果setResizable(false) 可以做到窗体大小不可变化
                        d.setResizable(flag);
                        flag = !flag;
                        button.setText((flag==true) ?"解锁大小":"锁定大小");

                    }
                });
                d.setSize(400, 300);
                d.setLocation(200, 200);
                d.setLayout(null);
                d.setVisible(true);
            }
        });
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
