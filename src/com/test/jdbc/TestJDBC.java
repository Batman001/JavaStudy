package com.company.caini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by Batman on 2018/10/22.
 * @author Batman
 */
public class TestJDBC {

    /**
     * 增删改操作
     * @param sql 传入增删改的参数,执行对应的SQL语句
     *
     */
    public static void execute(String sql){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root", "Newworld0707"
        );Statement s = c.createStatement()){
            // execute返回值类型为boolean类型
            s.execute(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            String heroName = "'英雄 " + i + "'";
            String currentSql = "insert into hero values(null," + heroName + "," + 313.0f + "," + 50 + ")";
            execute(currentSql);
        }
        String deleteSql = "delete from hero where id=5";
        execute(deleteSql);
        String updateSql = "update hero set name='扁鹊' where id=101";
        execute(updateSql);


    }
}
