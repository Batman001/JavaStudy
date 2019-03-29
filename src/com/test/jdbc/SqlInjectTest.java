package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by Batman on 2018/10/23.
 */
public class SqlInjectTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "select * from hero where name = ?";
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root", "Newworld0707");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql);
        ){
            // 假设name是用户提交来的数据
            String name = "'提莫' OR 1=1";
            String sql_s = "select * from hero where name = " + name;
            // 拼接出来的SQL语句就是
            // select * from hero where name = '盖伦' OR 1=1
            // 因为有OR 1=1，所以恒成立
            // 那么就会把所有的英雄都查出来，而不只是盖伦
            // 如果Hero表里的数据时海量的，比如几百万条，把这个表里的数据全部查出来
            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
            System.out.println("拼接出来的SQL语句为:"+sql_s);

            ResultSet rs_s = s.executeQuery(sql_s);
            while(rs_s.next()){
                String heroName = rs_s.getString("name");
                System.out.println(heroName);
            }

            // 使用Preparement可以有效预防SQL注入
            System.out.println("使用PreparedStatement进行SQL查询");
            ps.setString(1, name);
            ResultSet rs_prepare_s = ps.executeQuery();
            while(rs_prepare_s.next()){
                String heroName = rs_prepare_s.getString("name");
                System.out.println(heroName);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

