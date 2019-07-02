package com.test.gui;

import com.test.jdbc.HeroDAO;
import com.test.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2018/11/14.
 * table初始化后,应该默认选中第一行
 * 增加数据后,也应该选中增加的这一条
 */
public class TableSelectRow {
    public static void main(String[] args) {
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        final HeroTableModel htm = new HeroTableModel();
        final JTable t = new JTable(htm);

        // 设置选择模式为 只能选中一行
        t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        t.setSelectionBackground(Color.GRAY);
        // 选中第一行
        t.getSelectionModel().setSelectionInterval(0, 0);


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


        /**
         * 要严格按照添加的顺序进行添加
         * 先添加Label 然后添加TextFiled(that's important)
         */

        p.add(lName);p.add(tfName);p.add(lHp);p.add(tfHp);p.add(lDamage);p.add(tfDamage);
        p.add(bAdd);

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroDAO dao = new HeroDAO();
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
                // 即时更新表格中数据
                htm.heros = dao.listAllData();
                t.updateUI();

                // 选中第一行 因为DAO是按照ID倒排序查询,所以第一行就是新加入的数据
                t.getSelectionModel().setSelectionInterval(0,0);


            }
       });

        // 带滚动条的表格
        JScrollPane sp = new JScrollPane(t);
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);



    }
}
