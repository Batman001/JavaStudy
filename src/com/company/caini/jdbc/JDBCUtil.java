package com.company.caini.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sunchao on 2018/10/25.
 * @author Batman
 * JDBC数据库连接类
 */
public class JDBCUtil {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "Newworld0707";

    public Connection getCon() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void getClose(Connection c) throws SQLException{
        if(c!=null){
            c.close();
        }
    }

    public static void main(String[] args) {
        JDBCUtil db = new JDBCUtil();
        try{
            Connection c = db.getCon();
            System.out.println("测试连接数据库,连接成功");
            db.getClose(c);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("测试连接数据库,连接失败");
        }
    }


}
