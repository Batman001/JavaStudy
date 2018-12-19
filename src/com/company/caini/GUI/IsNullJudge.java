package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunchao on 2018/11/12.
 * 练习  为空判断
 */
public class IsNullJudge {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JTextField tf = new JTextField("初始设置为非空");
        tf.setPreferredSize(new Dimension(80, 30));
        JButton b = new JButton("检测");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                if(0==text.length()){
                    JOptionPane.showMessageDialog(f, "文本内容为空");
                    tf.grabFocus();
                }
                else{
                    JOptionPane.showMessageDialog(f,"检测到文本内容,内容为" + text);
                }

            }
        });
        f.add(tf);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);



    }
}
