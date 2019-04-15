package com.test.GUI;

import com.test.jdbc.HeroDAO;
import com.test.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2018/11/20.
 * @author Batman
 * 使用按钮进行分页
 * 在table中仅仅显示10条数据。
 * 在下方出现4个按钮 首页 上一页 下一页 末页
 * 最后一页需要注意，如果数据库中的总数能够整除10，那么最后一页就显示10个，否则就显示不到除以10的余数。
 * 比如一共是25个，那么最后一页就显示5个。
 * 按钮的状态要求：如果有下一页的数据，才能点击下一页，否则下一页按钮是不可用的。
 */
public class addButtonPaging {

    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);

    // 把分页按钮放在这里，后面监听器好访问
    static JButton bFirst = new JButton("首页");
    static JButton bPre = new JButton("上一页");
    static JButton bNext = new JButton("下一页");
    static JButton bLast = new JButton("末页");

    //每页显示10个
    static int viewNumber = 10;

    //开始的页码
    static int start = 0;

    public static void main(String[] args) {
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        t.getSelectionModel().setSelectionInterval(0, 0);

        JPanel pOperation = new JPanel();
        JButton bAdd = new JButton("增加");
        JButton bDelete = new JButton("删除");
        JButton bEdit = new JButton("编辑");
        pOperation.add(bAdd);pOperation.add(bDelete);pOperation.add(bEdit);

        JPanel pPage = new JPanel();
        pPage.add(bFirst);pPage.add(bPre);pPage.add(bNext);pPage.add(bLast);

        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否被选中
                int index = t.getSelectedRow();
                if(-1 == index){
                    JOptionPane.showMessageDialog(f, "编辑前要选中一行");
                    return;
                }
                // 获取选中的对象
                JDBCHero h = htm.heros.get(index);

                // 显示编辑的dialog
                EditDialog ed = new EditDialog(f);
                ed.tfName.setText(h.getName());
                ed.tfHp.setText(String.valueOf(h.getHp()));
                ed.tfDamage.setText(String.valueOf(h.getDamage()));
                ed.setVisible(true);
            }
        });

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
                updateButtonStatus();
            }
        });

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否被选中
                int index = t.getSelectedRow();
                if(-1==index){
                    JOptionPane.showMessageDialog(f, "删除前需要先选中一行");
                    return;
                }
                // 进行判断是否删除
                if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "是否删除?")){
                    return;
                }

                // 获取所选英雄的信息
                int id = htm.heros.get(index).getId();
                new HeroDAO().delete(id);

                start = 0;
                // 更新table
                updateTable();
                updateButtonStatus();

            }
        });

        addPageListener();

        JScrollPane sp = new JScrollPane(t);
        f.setLayout(null);
        sp.setBounds(0, 0, 394, 200);
        pOperation.setBounds(0, 200, 394, 50);
        pPage.setBounds(0, 250, 394, 200);
        f.add(sp);
        f.add(pOperation);
        f.add(pPage);
        updateButtonStatus();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static void addPageListener(){
        bFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = 0;
                updateTable();
                updateButtonStatus();
            }
        });

        bPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start -= viewNumber;
                updateTable();
                updateButtonStatus();
            }
        });

        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start += viewNumber;
                updateTable();
                updateButtonStatus();
            }
        });

        bLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = last();
                updateTable();
                updateButtonStatus();
            }
        });
    }
    private static void updateButtonStatus() {
        int last = last();

        // 是否有上一页
        if (0 != start) {
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }

        // 是否是第一页
        if (0 == start) {
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }

        // 是否是最后一页
        if (start == last) {
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }
        // 是否有下一页
        if (start < last) {
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }

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
            bSubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {

                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                            int damage = Integer.parseInt(tfDamage.getText());

                            JDBCHero h = new JDBCHero();
                            h.setName(name);
                            h.setHp(hp);


                            new HeroDAO().add(h);

                            JOptionPane.showMessageDialog(f, "提交成功 ");

                            AddDialog.this.setVisible(false);
                            start = 0;
                            updateTable();
                        }
                    }
                }
            });
        }
    }

    public static void updateTable() {
        htm.heros = new HeroDAO().list(start, viewNumber);
        t.updateUI();
        if (!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }

    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }

        return true;
    }

    static class EditDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();

        JLabel lDamage = new JLabel("伤害");
        JTextField tfDamage = new JTextField();



        JButton bSubmit = new JButton("提交");

        EditDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 20;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(3, 2, gap, gap));
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

            bSubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {

                            // 获取id
                            int index = t.getSelectedRow();
                            int id = htm.heros.get(index).getId();

                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());

                            JDBCHero h = new JDBCHero();
                            h.setName(name);
                            h.setHp(hp);
                            h.setId(id);


                            new HeroDAO().update(h);

                            JOptionPane.showMessageDialog(f, "提交成功 ");

                            EditDialog.this.setVisible(false);
                            updateTable();
                        }
                    }

                }
            });
        }
    }

    private static int last() {
        // 最后一页开始的位置
        int last;

        int total = new HeroDAO().getTotal();

        // 最后一页要看总是是否能够整除每页显示的数量number

        if (0 == total % viewNumber) {
            // 假设总数是20，那么最后一页开始的位置就是10
            last = total - viewNumber;
        } else {
            // 假设总数是21，那么最后一页开始的位置就是20
            last = total - total % viewNumber;
        }
        return last;

    }
}

