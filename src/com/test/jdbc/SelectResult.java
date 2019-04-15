package com.test.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Created by Batman on 2018/10/22.
 */
public class SelectResult {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root","Newworld0707");
            Statement s = c.createStatement()) {
            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                // 可以使用字段名
                int id = rs.getInt("id");
                // 也可以使用字段顺序
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt("damage");
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);

                // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
                // rs.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
