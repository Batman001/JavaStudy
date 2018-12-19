package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by sunchao on 2018/11/5.
 * 通过CardLayoutanel对面板进行切换
 */
public class CardLayoutTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        JPanel comboBoxPanel = new JPanel();
        String buttonPanel = "按钮面板";
        String inputPanel = "输入框面板";

        String comboBoxItems[] = {buttonPanel, inputPanel};
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        comboBoxPanel.add(cb);

        // 两个Panel充当卡片
        JPanel card1 = new JPanel();
        card1.add(new JButton("按钮 1"));
        card1.add(new JButton("按钮 2"));
        card1.add(new JButton("按钮 3"));

        JPanel card2 = new JPanel();
        // 添加文本域
        card2.add(new JTextField("输入框", 20));

        JPanel cards; // a panel that uses CardLayout
        cards = new JPanel(new CardLayout());
        cards.add(card1, buttonPanel);
        cards.add(card2, inputPanel);

        f.add(comboBoxPanel, BorderLayout.NORTH);
        f.add(cards, BorderLayout.CENTER);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        cb.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, (String) evt.getItem());
            }
        });
    }

}

