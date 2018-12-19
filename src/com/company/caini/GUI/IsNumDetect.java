package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunchao on 2018/11/12.
 * 练习 判断文本框中是否有数字判断
 */
public class IsNumDetect {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(80, 30));

        JButton b = new JButton("检测");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                boolean flag = false;
                Pattern p = Pattern.compile(".*\\d+.*");
                Matcher m = p.matcher(text);
                if(m.matches()){
                    flag = true;
                }
                if(flag){
                    JOptionPane.showMessageDialog(f, "字符串中出现数字");
                }
                else{
                    JOptionPane.showMessageDialog(f, "字符串中没有出现数字");
                }

            }
        });
        f.add(tf);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
}
