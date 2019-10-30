package com.test.network.chatRobot;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Batman on 2018/10/30.
 * @author Batman
 */
public class DictionaryDAO {

    public DictionaryDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8",
                "root", "Newworld0707"
        );
    }

    public List<Dictionary> query(String receive){
        List<Dictionary> ds = new ArrayList<>();

        String sql = "select * from dictionary where receive=?";
        try(
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, receive);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dictionary d = new Dictionary();
                int id = rs.getInt(1);
                String receiveGet = rs.getString("receive");
                String response = rs.getString("response");
                d.id = id;
                d.receive = receiveGet;
                d.response = response;
                ds.add(d);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return ds;
    }

    public static void main(String[] args) {
        DictionaryDAO dd = new DictionaryDAO();
        List<Dictionary> ds = dd.query("你好");
        Collections.shuffle(ds);
        while(ds.isEmpty()){
            System.out.println(ds.get(0).response);
        }


    }
}
