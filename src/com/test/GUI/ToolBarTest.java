package com.test.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/13.
 * SWING如何使用工具栏JToolBar
 * 工具栏用于存储常用的按钮
 */
public class ToolBarTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(500, 600);
        f.setLocation(200, 200);

        // 添加菜单栏
        addMenu(f);

        // 工具栏
        JToolBar tb = new JToolBar();
        // 为工具栏增加按钮
        JButton b1 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/1.jpg"));
        JButton b2 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/2.jpg"));
        JButton b3 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/3.jpg"));
        JButton b4 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/4.jpg"));
        JButton b5 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/5.jpg"));
        JButton b6 = new JButton(new ImageIcon("/Users/Batman/JavaProjects/JavaStudy/images/6.jpg"));

        // 给按钮设置提示信息
        b1.setToolTipText("坑爹英雄");

        // 禁止工具栏拖动
        tb.setFloatable(false);

        tb.add(b1);tb.add(b2);tb.add(b3);tb.add(b4);tb.add(b5);tb.add(b6);

        // 把工具栏放在North的位置
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static void addMenu(JFrame f) {
        // 菜单栏
        JMenuBar mb = new JMenuBar();

        // 菜单
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");

        // 给菜单加上菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("所有-All"));

        // 把菜单加到菜单栏
        mb.add(mHero);mb.add(mItem);mb.add(mWord);mb.add(mSummon);mb.add(mTalent);
        f.setJMenuBar(mb);

    }
}
