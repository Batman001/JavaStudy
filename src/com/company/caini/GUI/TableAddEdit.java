package com.company.caini.GUI;

import com.company.caini.jdbc.HeroDAO;
import com.company.caini.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sunchao on 2018/11/19.
 */
public class TableAddEdit {
    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);


    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 500);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        t.getSelectionModel().setSelectionInterval(0,0);


        JPanel pOperation = new JPanel();
        JButton bAdd = new JButton("增加");
        JButton bDelete = new JButton("删除");
        JButton bEdit = new JButton("编辑");
        pOperation.add(bAdd);pOperation.add(bDelete);pOperation.add(bEdit);

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);

            }
        });

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否被选中
                int index = t.getSelectedRow();
                if(-1==index){
                    JOptionPane.showMessageDialog(f, "删除前需要选中一行");
                    return;
                }

                // 进行确认删除
                if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "是否删除")){
                    return;
                }


                // 获取id
                JDBCHero h = htm.heros.get(index);
                int id = h.getId();

                // 删除
                new HeroDAO().delete(id);

                // 更新表格数据显示
                updateTable();
            }
        });

        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否被选中
                int index = t.getSelectedRow();
                if(-1 == index){
                    JOptionPane.showMessageDialog(f,"编辑前要先选中一行");
                    return;
                }

                // 获取选中的对象
                JDBCHero selectedHero = htm.heros.get(index);

                // 显示编辑Dialog
                EditDialog ed = new EditDialog(f);

                // 更新表格数据显示
                updateTable();

                ed.tfName.setText(selectedHero.getName());
                ed.tfHp.setText(String.valueOf((int)selectedHero.getHp()));
                ed.tfDamage.setText(String.valueOf(selectedHero.getDamage()));
                ed.setVisible(true);

            }
        });

        // 添加表格滚动条
        JScrollPane sp = new JScrollPane(t);
        f.add(sp,BorderLayout.CENTER);
        f.add(pOperation,BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
    static class AddDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
        JLabel lDamage = new JLabel("伤害");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
        JTextField tfDamage = new JTextField();

        JButton bSubmit = new JButton("提交");

        AddDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 20;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(3, 2, gap, gap));

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

            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);

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
    }

    public static void updateTable(){
        htm.heros = new HeroDAO().listAllData();
        t.updateUI();
        if(!htm.heros.isEmpty()){
            t.getSelectionModel().setSelectionInterval(0,0);
        }
    }

    public static boolean checkEmpty(JTextField tf, String msg){
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null, msg+"不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkNumber(JTextField tf, String msg){
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null, msg+"不能为空");
            tf.grabFocus();
            return false;
        }
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, msg+"只能是整数");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    static class EditDialog extends JDialog{
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
        JLabel lDamage = new JLabel("伤害");
        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
        JTextField tfDamage = new JTextField();

        JButton bSubmit = new JButton("提交");


        EditDialog(JFrame f){
            super(f);
            this.setModal(true);
            int gap = 20;
            this.setLayout(null);
            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(3,2,gap,gap));
            pInput.add(lName);pInput.add(tfName);
            pInput.add(lHp);pInput.add(tfHp);
            pInput.add(lDamage);pInput.add(tfDamage);
            pSubmit.add(bSubmit);
            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);

            this.add(pInput);
            this.add(pSubmit);

            this.setSize(300, 200);
            this.setLocationRelativeTo(f);

            // 对编辑后的内容进行更新并通过JTable进行展示
            bSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkEmpty(tfName, "名称")){
                        if(checkNumber(tfHp,"血量")){
                            if(checkNumber(tfDamage, "伤害")){
                                // 获取id信息
                                int index = t.getSelectedRow();
                                int id = htm.heros.get(index).getId();

                                String name = tfName.getText();
                                float hp = Float.parseFloat(tfHp.getText());
                                int damage = Integer.parseInt(tfDamage.getText());


//                                JDBCHero newHero = new JDBCHero();
//                                newHero.setId(id);
//                                newHero.setName(name);
//                                newHero.setHp(hp);
//                                newHero.setDamage(damage);
                                new HeroDAO().update(name, hp, damage, id);
                                JOptionPane.showMessageDialog(f, "提交成功");
                                EditDialog.this.setVisible(false);
                                updateTable();

                            }
                        }
                    }
                }

            });

        }

    }

}

