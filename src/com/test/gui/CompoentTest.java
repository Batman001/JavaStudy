package com.test.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batman on 2018/11/1.
 */
public class CompoentTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 240);
        f.setLayout(new FlowLayout());
        /**
         * JLabel显示文字
         */
//        JLabel l = new JLabel("LoL文字");
//        // 文字颜色
//        l.setForeground(Color.red);
//        l.setBounds(50, 50, 280, 30);

        /**
         * JLabel显示图片
         */
//        JLabel l = new JLabel();
//        // 根据图片创建ImageIcon对象
//        ImageIcon i = new ImageIcon("/Users/Batman/Desktop/shana.png");
//        // 设置ImageIcon
//        l.setIcon(i);
//        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
//
//
//        // 添加按钮
//        JButton b = new JButton("一秒秒掉对面基地");
//
//        b.setBounds(200, 200, 280, 30);
//        f.add(b);
//
//        f.add(l);

//        // 添加复选框
//        JCheckBox bCheckBox = new JCheckBox("物理英雄");
//        // 设置为 默认被选中
//        bCheckBox.setSelected(true);
//        bCheckBox.setBounds(50, 50, 130, 30);
//        JCheckBox bCheckBox2 = new JCheckBox("魔法 英雄");
//        bCheckBox2.setBounds(50, 100, 130, 30);
//        //判断 是否 被 选中
//        System.out.println(bCheckBox2.isSelected());
//        f.add(bCheckBox);
//        f.add(bCheckBox2);

//        // 添加单选框
//        JRadioButton b1 = new JRadioButton("物理英雄");
//        b1.setSelected(true);
//        b1.setBounds(50, 50, 130, 130);
//        JRadioButton b2 = new JRadioButton("魔法英雄");
//        b2.setBounds(50, 100, 130, 130);
//        System.out.println(b2.isSelected());
//
//        f.add(b1);f.add(b2);


//        // 按钮组
//        JRadioButton b1 = new JRadioButton("物理英雄");
//        b1.setSelected(true);
//        b1.setBounds(50, 50, 130, 30);
//        JRadioButton b2 = new JRadioButton("魔法 英雄");
//        b2.setBounds(50, 100, 130, 30);
//        // 按钮分组
//        ButtonGroup bg = new ButtonGroup();
//        // 把b1，b2放在 同一个 按钮分组对象里 ，这样同一时间，只有一个 按钮 会被选中
//        bg.add(b1);
//        bg.add(b2);
//        f.add(b1);f.add(b2);

//
//        // 下拉框
//        String[] heros = new String[]{"卡特琳娜","库奇"};
//        JComboBox cb = new JComboBox(heros);
//        cb.setBounds(50, 50, 80, 30);
//        f.add(cb);


//        // 对话框
//        int option = JOptionPane.showConfirmDialog(f, "是否使用外挂");
//        if(JOptionPane.OK_OPTION == option){
//            String answer = JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
//            if("yes".equals(answer))
//                JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
//        }

//        // 文本框
//        JLabel lName = new JLabel("账号:");
//        // 输入框
//        JTextField tfName = new JTextField("");
//        tfName.setText("请输入账号");
//        tfName.setPreferredSize(new Dimension(80, 30));
//
//        JLabel lPassword = new JLabel("密码:");
//        // 输入框
//        JTextField tfPassword = new JTextField("");
//        tfPassword.setText("请输入密码");
//        tfPassword.setPreferredSize(new Dimension(80, 30));
//
//        f.add(lName);f.add(tfName);f.add(lPassword);f.add(tfPassword);
//        tfPassword.grabFocus();


//        // 密码框
//        JLabel l = new JLabel("密码:");
//        JPasswordField pf = new JPasswordField("");
//        pf.setText("&48kdh4@#");
//        pf.setPreferredSize(new Dimension(80, 30));
//
//        // 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个字符数组，而非字符串
//        char[] password = pf.getPassword();
//        String p = String.valueOf(password);
//        System.out.println(p);
//
//        f.add(l);
//        f.add(pf);

//        // 文本域
//        JLabel l = new JLabel("文本域:");
//        JTextArea ta = new JTextArea();
//        ta.setPreferredSize(new Dimension(200, 150));
//        // 换行符
//        ta.setText("抢人头,~\n抢你妹呀 抢\n");
//        // 追加数据
//        ta.append("那我去送人头了略略略....");
//        // 设置自动换行
//        ta.setLineWrap(true);
//
//        f.add(l);f.add(ta);


        // 进度条
        JProgressBar pb = new JProgressBar();
        // 进度条最大100
        pb.setMaximum(100);
        // 当前进度50
        pb.setValue(50);

        // 显示当前进度
        pb.setStringPainted(true);
        f.add(pb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

}
