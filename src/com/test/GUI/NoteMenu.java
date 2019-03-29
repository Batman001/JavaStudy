package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/13.
 * 使用swing完成一个记事本页面
 */
public class NoteMenu {
    public static void main(String[] args) {
        JFrame f = new JFrame("记事本");
        f.setSize(400, 500);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        // 菜单栏
        JMenuBar mb = new JMenuBar();

        // 菜单
        JMenu file = new JMenu("文件");
        file.setMnemonic('F');
        JMenu edit = new JMenu("编辑(E)");
        JMenu format = new JMenu("格式(O)");
        JMenu look = new JMenu("查看(V)");
        JMenu help = new JMenu("帮助(H)");

        // 给菜单添加菜单项
        file.add(new JMenuItem("新建(N)"));

        file.add(new JMenuItem("打开(O)"));
        file.add(new JMenuItem("保存(S)"));
        file.add(new JMenuItem("另存为(A)"));
        file.addSeparator();
        file.add(new JMenuItem("页面设置(U)"));
        file.add(new JMenuItem("打印(P)"));
        file.addSeparator();
        file.add(new JMenuItem("退出(X)"));

        // 把菜单加到菜单栏
        mb.add(file);mb.add(edit);mb.add(format);mb.add(look);mb.add(help);

        // 把菜单栏加到窗体上
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);




    }
}
