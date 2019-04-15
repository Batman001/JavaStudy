package com.test.GUI;

import com.test.jdbc.HeroDAO;
import com.test.jdbc.JDBCHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Batman on 2018/11/26.
 * 使用下拉框分页
 */
public class TableDropDownBoxPage {
    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);

    /**
     * 把分页按钮放在这里,方便后面监听器访问
     */
    static JButton bFirst = new JButton("首页");
    static JButton bPre = new JButton("上一页");
    static JButton bNext = new JButton("写一页");
    static JButton bLast = new JButton("末页");
    static JComboBox<Integer> cb = new JComboBox<>();

    /**
     * 每页显示10个
     */
    static int number = 10;

    /**
     * 开始的页码
     */
    static int start = 0;


    private static boolean cbListenerEnabled=true;

    public static void main(String[] args) {
        final JFrame f = new JFrame("LoL");
        f.setSize(500, 440);
        f.setLocation(200, 200);

        t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        t.getSelectionModel().setSelectionInterval(0,0);

        JPanel pOperation = new JPanel();
        JButton bAdd = new JButton("增加");
        JButton bDelete = new JButton("删除");
        JButton bEdit = new JButton("编辑");
        pOperation.add(bAdd);
        pOperation.add(bDelete);
        pOperation.add(bEdit);

        JPanel pPage = new JPanel();

        pPage.add(bFirst);
        pPage.add(bPre);
        pPage.add(cb);

        pPage.add(bNext);
        pPage.add(bLast);

        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否被选中
                int index = t.getSelectedRow();
                if(index == -1){
                    JOptionPane.showMessageDialog(f,"编辑前请选中一行");
                    return;
                }
                // 获取选中的对象
                JDBCHero hero = htm.heros.get(index);

                // 显示编辑Dialog

                EditDialog ed = new EditDialog(f);
                ed.tfName.setText(hero.getName());
                ed.tfHp.setText(String.valueOf((int) hero.getHp()));
                ed.tfDamage.setText(String.valueOf(hero.getDamage()));

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
                    JOptionPane.showMessageDialog(f, "删除前请选中一行");
                    return;
                }

                // 进行确认是否删除
                if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f,"确认删除")){
                    return;
                }
                JDBCHero selectedHero = htm.heros.get(index);
                int id = selectedHero.getId();
                new HeroDAO().delete(id);
                // 更新table
                start=0;

                updateTable();

                updateButtonStatus();

            }
        });
        addPageListener();

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cbListenerEnabled){
                    return;
                }
                int currentPage = (int) cb.getSelectedItem();
                start = (currentPage-1) * number;

                updateTable();

                updateButtonStatus();


            }
        });

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

    private static void updateButtonStatus() {
        int last = last();

        // 是否有上一页
        if(0 != start){
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }

        // 是否是第一页
        if(0==start){
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }

        // 是否是最后一页
        if(start == last){
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }

        // 是否有下一页
        if(start < last){
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }

        // 总共的页数
        int pageNumbers = last/number + 1;
        cbListenerEnabled = false;
        cb.removeAllItems();

        for(int i=0;i<pageNumbers;i++){
            cb.addItem(i+1);
        }
        cbListenerEnabled = true;

        int currentPage = start/number + 1;
        cb.setSelectedItem(currentPage);

    }

    private static void addPageListener() {
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
                start -= number;
                updateTable();
                updateButtonStatus();
            }
        });

        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start += number;
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


    private static void updateTable(){
        htm.heros = new HeroDAO().list(start, number);
        t.updateUI();
        if(!htm.heros.isEmpty()){
            t.getSelectionModel().setSelectionInterval(0,0);
        }

    }

    private static int last(){
        // 最后一页开始的位置
        int last;
        int total = new HeroDAO().getTotal();

        // 最后一页要看总是是否能够整除每页显示的数量number
        if(0==total%number){
            last = total-number;
        }else{
            last = total - total % number;
        }
        return last;
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
                            if(checkNumber(tfDamage, "damage")) {

                                String name = tfName.getText();
                                int hp = Integer.parseInt(tfHp.getText());
                                int damage = Integer.parseInt(tfDamage.getText());

                                JDBCHero h = new JDBCHero();
                                h.setName(name);
                                h.setHp(hp);
                                h.setDamage(damage);


                                new HeroDAO().add(h);

                                JOptionPane.showMessageDialog(f, "提交成功 ");

                                AddDialog.this.setVisible(false);
                                start = 0;
                                updateTable();
                            }
                        }
                    }
                }
            });
        }
    }
    static class EditDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
        JLabel lDamage = new JLabel("伤害");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
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
                            if(checkNumber(tfDamage, "damage")) {

                                // 获取id
                                int index = t.getSelectedRow();
                                int id = htm.heros.get(index).getId();

                                String name = tfName.getText();
                                int hp = Integer.parseInt(tfHp.getText());
                                int damage = Integer.parseInt(tfDamage.getText());

                                JDBCHero h = new JDBCHero();
                                h.setName(name);
                                h.setHp(hp);
                                h.setId(id);
                                h.setDamage(damage);

                                new HeroDAO().update(h);

                                JOptionPane.showMessageDialog(f, "提交成功 ");

                                EditDialog.this.setVisible(false);
                                updateTable();
                            }
                        }
                    }

                }
            });
        }
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

}
