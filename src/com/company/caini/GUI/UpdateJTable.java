package com.company.caini.GUI;

import com.company.caini.jdbc.HeroDAO;
import com.company.caini.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunchao on 2018/11/14.
 * 更新Table
 * 以新增数据到数据库中，然后更新Table为例
 */
public class UpdateJTable {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(500, 400);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        final HeroTableModel htm = new HeroTableModel();
        final JTable t = new JTable(htm);

        // 增加一个Panel用于放置名称 血量输入框和增加按钮
        JPanel p = new JPanel();
        final JLabel lName = new JLabel("名称");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("血量");
        final JTextField tfHp = new JTextField("");
        final JLabel lDamage = new JLabel("伤害");
        final JTextField tfDamage = new JTextField("");

        JButton bAdd = new JButton("增加");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));
        tfDamage.setPreferredSize(new Dimension(80, 30));

        p.add(lName);p.add(tfName);p.add(lHp);p.add(tfHp);p.add(lDamage);p.add(tfDamage);p.add(bAdd);

        // 为按钮增加监听
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * 对输入框的内容进行验证
                 */
                HeroDAO dao = new HeroDAO();

                // 根据输入框新建一个JDBCHero对象
                JDBCHero h = new JDBCHero();

                // name设置部分
                String name = tfName.getText();
                if (name.length() == 0){
                    // 弹出对话框
                    JOptionPane.showMessageDialog(f,"输入英雄的名称不能为空!");
                    // 名称输入框获取焦点
                    tfName.grabFocus();
                    return;
                }
                h.setName(name);

                // hp设置部分
                String hp = tfHp.getText().trim();
                try{
                    // 把血量转换为浮点型,如果出现NumberFormatException异常表明不是浮点型格式
                    float hpParse = Float.parseFloat(hp);
                    h.setHp(hpParse);

                }catch(NumberFormatException e1){
                    JOptionPane.showMessageDialog(f, "血量只能是浮点数");
                    tfHp.grabFocus();
                    return;
                }

                // damage设置部分
                String damageStr = tfDamage.getText().trim();
                try{
                    int damage = Integer.parseInt(damageStr);
                    h.setDamage(damage);

                }catch(NumberFormatException e2){
                    JOptionPane.showMessageDialog(f,"伤害值只能是数值");
                    tfDamage.grabFocus();
                    return;
                }

                // 使用dao工具类将对象插入到数据库中
                dao.add(h);

                // 通过dao更新tableModel中数据
                htm.heros = dao.listAllData();

                // 调用JTable的updateUI，刷新界面。
                // 刷新界面的时候，会到tablemodel中去取最新的数据
                // 就能看到新加进去的数据了
                t.updateUI();

            }
        });

        JScrollPane sp = new JScrollPane(t);
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
