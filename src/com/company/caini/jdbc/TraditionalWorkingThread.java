package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by Batman on 2018/10/26.
 */
public class TraditionalWorkingThread extends Thread {
    @Override
    public void run(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String insertSql = "insert into hero values(null,?,?,?)";
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                        "root", "Newworld0707");
                PreparedStatement ps = c.prepareStatement(insertSql)){
            for(int i=0;i < TestConnectionPoolAndTraditionConnection.insertTime;i++){
                ps.setString(1, "猪八戒");
                ps.setFloat(2, 300.0f);
                ps.setInt(3, 19);
                ps.execute();
            }

        }catch(SQLException e1){
            e1.printStackTrace();
        }

    }

}
