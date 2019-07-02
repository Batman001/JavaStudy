package com.test.gui;

import com.test.jdbc.JDBCHero;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by Batman on 2018/11/13.
 * 通过table可以获取一个 TableSelectionModel，专门用于监听jtable选中项的变化
 */
public class TableSelectionModel {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        final HeroTableModel htm = new HeroTableModel();
        final JTable t = new JTable(htm);

        // 准备一个Panel上放置一个Label用于显示哪条被选中了
        JPanel p = new JPanel();
        final JLabel l = new JLabel("暂时未选中条目");
        p.add(l);

        JScrollPane sp = new JScrollPane(t);

        // 使用selection监听器来监听table的哪个条目被选中了
        t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            // 当选择某一行的时候触发该事件
            public void valueChanged(ListSelectionEvent e) {
                // 获取哪一行被选中了
                int row = t.getSelectedRow();
                // 根据选中行去HeroTableModel获取对应的对象
                JDBCHero h = htm.heros.get(row);
                // 更新标签内容
                l.setText("当前选中的英雄是:" + h.getName());

            }
        });

        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
