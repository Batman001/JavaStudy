package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/13.
 * 对HeroTableModel进行展示用
 */
public class HeroTableModelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(300, 400);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        // 创建一个TableModel
        HeroTableModel htm = new HeroTableModel();

        // 根据TableModel来创建Table
        JTable t = new JTable(htm);

        JScrollPane sp = new JScrollPane(t);

        f.add(sp, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
