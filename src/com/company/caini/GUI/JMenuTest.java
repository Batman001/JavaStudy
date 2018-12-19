package com.company.caini.GUI;

import javax.swing.*;

/**
 * Created by sunchao on 2018/11/13.
 * 如何在swing中使用菜单JMenu
 */
public class JMenuTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

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

        // 把菜单栏加到Frame中 这是使用set
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

}
