package com.test.gui;

import javax.swing.*;

/**
 * Created by Batman on 2018/11/1.
 * 当一个对话框设置为模态的时候,其背后的父窗体,是不能被激活的,除非该对话框被关闭
 */
public class JDialogTest {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocation(100, 100);

        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);

        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        d.add(b);

        f.setVisible(true);
        d.setVisible(true);

        // 窗体大小不可变化
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






    }
}
