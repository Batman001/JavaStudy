package com.test.jdbc;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Batman on 2018/10/23.
 * @author Batman
 */
public class transactionTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root", "Newworld0707");
            Statement s = c.createStatement();
        ){
            // 在事务的前提下 事务中的多个操作,要么都成功,要么都失败
            c.setAutoCommit(false);

            // 加血sql
            String addSql = "update hero set hp = hp + 1 where id=21000";
            s.execute(addSql);

            // 减血sql
            String reduceSql = "updata hero set hp = hp -1 where id = 21000";
            s.execute(reduceSql);

            // 手动提交
            c.commit();


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
