package com.test.gui;

import com.test.jdbc.HeroDAO;
import com.test.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2018/11/16.
 * 点击增加按钮，出现一个JDialog，在JDialog中进行增加
 * 1. 首先把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
 * 2. 设计一个静态内部类 AddDialog用于显示增加的界面
 * 3. 在AddDialog中点击提交按钮后，进行为空和数字判断，然后通过dao提交到数据库
 * 4. 隐藏这个AddDialog，并刷新table中的数据
 */
public class TableAddDialog {
    // htm 和 table设为静态,方便在后面更新表格数据时候,容易访问对象

    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(500, 600);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        t.getSelectionModel().setSelectionInterval(0,0);

        JPanel pOperation = new JPanel();
        JButton b = new JButton("增加");
        pOperation.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
            }
        });

        // 添加滚动条
        JScrollPane sp = new JScrollPane(t);
        f.add(sp, BorderLayout.CENTER);
        f.add(pOperation, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }


    static class AddDialog extends JDialog{
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
        JLabel lDamage = new JLabel("伤害");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
        JTextField tfDamage = new JTextField();



        JButton bSubmit = new JButton("提交");

        AddDialog(JFrame f){
            super(f);
            this.setModal(true);
            int gap = 20;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(3,2, gap, gap));

            tfName.setPreferredSize(new Dimension(80, 30));
            tfHp.setPreferredSize(new Dimension(50, 30));
            tfDamage.setPreferredSize(new Dimension(50, 30));

            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
            pInput.add(lDamage);
            pInput.add(tfDamage);

            pSubmit.add(bSubmit);

            pInput.setBounds(50,20,200,100);
            pSubmit.setBounds(0,130,300,150);

            this.add(pInput);
            this.add(pSubmit);


            this.setSize(300, 200);
            this.setLocationRelativeTo(f);

            // 添加提交按钮监听
            bSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkEmpty(tfName, "名称")){
                        if(checkNumber(tfHp, "血量")){
                            if(checkNumber(tfDamage, "伤害")){
                                String name = tfName.getText();
                                int hp = Integer.parseInt(tfHp.getText());
                                int damage = Integer.parseInt(tfDamage.getText());

                                JDBCHero h = new JDBCHero();
                                h.setName(name);
                                h.setHp(hp);
                                h.setDamage(damage);
                                new HeroDAO().add(h);
                                JOptionPane.showMessageDialog(f, "提交成功");
                                AddDialog.this.setVisible(false);
                                updateTable();
                            }
                        }
                    }
                }


            });

        }

        private static void updateTable() {
            htm.heros = new HeroDAO().listAllData();
            t.updateUI();
            if(!htm.heros.isEmpty()){
                t.getSelectionModel().setSelectionInterval(0, 0);
            }
        }

        private boolean checkNumber(JTextField tfHp, String msg) {
            String hpStr = tfHp.getText();
            if(0==hpStr.length()){
                JOptionPane.showMessageDialog(null, msg+"不能为空");
                tfName.grabFocus();
                return false;
            }
            try{
                Integer.parseInt(hpStr);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, msg+"只能是整数");
                tfHp.grabFocus();
                return false;
            }
            return true;
        }

        private boolean checkEmpty(JTextField tfName, String msg) {
            String value = tfName.getText();
            if(0==value.length()){
                JOptionPane.showMessageDialog(null, msg+"不能为空");
                tfName.grabFocus();
                return false;
            }
            return true;
        }




    }

}
