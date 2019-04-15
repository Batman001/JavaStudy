package com.test.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/13.
 * 使用SWING JTable详解
 */
public class JTableTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL-Table");
        f.setSize(300, 400);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        // 表格上的title
        String[] columnNames = new String[]{"id", "name", "hp", "damage"};
        // 表格的内容是一个二维数组
        String[][] heros = new String[][]{
                {"1", "盖伦", "616", "100"},
                {"2", "提莫", "512", "102"},
                {"3", "奎因", "832", "200"},
                {"4", "猴子", "932", "210"}};
        JTable t = new JTable(heros, columnNames);


//        JScrollPane: 带滚动条的Panel  可以显示出列名称
        JScrollPane sp = new JScrollPane(t);

        // 设置列宽度
        t.getColumnModel().getColumn(0).setPreferredWidth(10);

        f.add(sp, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
