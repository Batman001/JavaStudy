package com.test.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/1.
 * @author Batman
 * 计算器布局
 */
public class Homework2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("卡西欧计算器");
        f.setSize(390, 310);
        f.setLocation(200, 200);
        //设置窗体不可改变大小
        f.setResizable(false);
        f.setLayout(new FlowLayout(1, 10, 10));
        String[] ss = {"7", "8", "9","/","sq","4","5","6",
                "*","%","1","2","3","-","1/x","0","+/-",".","+","="};
        for(int i=0;i<ss.length;i++){
            JButton b = new JButton(ss[i]);
            b.setPreferredSize(new Dimension(58, 58));
            f.add(b);
        }

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
