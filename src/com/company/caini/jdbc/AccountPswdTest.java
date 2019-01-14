package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by Batman on 2018/10/22.
 */
public class AccountPswdTest {
    /**
     * 分页查询
     * @param start:表示开始页数 count:表示一页显示的总数
     */
    public static String list(int start, int count){
        String sql = "select * from hero limit " + start + "," + count;
        return sql;

    }


    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root","Newworld0707"); Statement s = c.createStatement()) {

//            String name = "dashen";
//            //正确的密码是：thisispassword
//            String password = "thisispassword1";
//            String sql = "select * from user where name='" + name + "' and password = '" + password + "'";
//
//            // 执行查询语句
//            ResultSet rs = s.executeQuery(sql);
//            if(rs.next()){
//                System.out.println("账号密码正确");
//            }
//            else{
//                System.out.printf("账号密码错误");
//            }
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("表Hero中总共有:" + total+" 条数据");
            s.execute(list(1, 10));


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
