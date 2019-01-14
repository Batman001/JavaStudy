package com.company.caini.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Batman on 2018/11/12.
 * 练习 账号-密码验证
 */
public class AccountPaswdVarify {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 500);
        f.setLocation(200, 200);

        JPanel pNorth = new JPanel();
        pNorth.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();

        JLabel lName = new JLabel("账号：");
        JTextField tfName = new JTextField("");
        tfName.setText("");
        tfName.setPreferredSize(new Dimension(80, 30));

        JLabel lPassword = new JLabel("密码:");
        JPasswordField tfPasswrd = new JPasswordField("");
        tfPasswrd.setText("");
        tfPasswrd.setPreferredSize(new Dimension(80, 30));

        pNorth.add(lName);
        pNorth.add(tfName);
        pNorth.add(lPassword);
        pNorth.add(tfPasswrd);

        JButton b = new JButton("登陆");
        pCenter.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String password = new String(tfPasswrd.getPassword());
                if(0==name.length()){
                    JOptionPane.showMessageDialog(f, "账号不能为空");
                    tfName.grabFocus();
                    return;
                }
                if(0==password.length()){
                    JOptionPane.showMessageDialog(f, "密码不能为空");
                    tfPasswrd.grabFocus();
                    return;
                }
                if(check(name, password)){
                    JOptionPane.showMessageDialog(f, "登陆成功");
                }
                else{
                    JOptionPane.showMessageDialog(f, "密码错误");
                }
                
            }
        });

        f.setLayout(new BorderLayout());

        f.add(pNorth, BorderLayout.NORTH);
        f.add(pCenter, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

    private static boolean PScheck(String name, String password) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        boolean result = false;
        String sql = "select * from user where name = ? and password = ?";
        try(
                Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Newworld0707");
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private static boolean check(String name, String password) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        boolean result = false;
        String sql = "select * from user where name = '" + name + "' and password = '"+password + "'";
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "Newworld0707");
                Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                result = true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
