package com.company.caini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Batman on 2018/10/23.
 * @author Batman
 */

/**
 * PreparedStatement有预编译机制，性能比Statement更快
 * PreparedStatement 使用参数设置，可读性好，不易犯错
 */
public class PreparedStatementTest{
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root","Newworld0707");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql)){
//            // 设置参数
//            ps.setString(1, "提莫");
//            ps.setFloat(2, 313.0f);
//            ps.setInt(3, 50);
//            // 执行SQL语句
//            ps.execute();

            // Statement执行10次，需要10次把SQL语句传输到数据库端
            // 数据库要对每一次来的SQL语句进行编译处理

            long start = System.currentTimeMillis();
            for(int i=0;i<10000;i++){
                String sql0="insert into hero values(null," + "'提莫'" + "," + 313.0f + ","
                        + 50 + ")";
                s.execute(sql0);
            }
            s.close();
            long end = System.currentTimeMillis();
            System.out.printf("使用Statement插入数据10000条共花费时间为 %d 毫秒%n",end-start);

            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
            // 数据库对带?的SQL进行预编译

            // 每次执行，只需要传输参数到数据库端
            // 1. 网络传输量比Statement更小
            // 2. 数据库不需要再进行编译，响应更快

            long start1 = System.currentTimeMillis();
            for(int i=0;i<10;i++){
                ps.setString(1, "Teemo");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            long end1 = System.currentTimeMillis();
            System.out.printf("使用PreparedStatement插入数据10000条共花费时间为 %d 毫秒%n",end1-start1);


        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
