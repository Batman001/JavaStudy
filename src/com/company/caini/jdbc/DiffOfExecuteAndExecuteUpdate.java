package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by Batman on 2018/10/23.
 */
public class DiffOfExecuteAndExecuteUpdate {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root", "Newworld0707");
            Statement s = c.createStatement()){
//            String sqlInsert = "insert into Hero values (null,'盖伦',616,100)";
//            String sqlDelete = "delete from Hero where id = 100";
//            String sqlUpdate = "update Hero set hp = 300 where id = 100";
//
//            // 相同点：都可以执行增加，删除，修改
//            s.execute(sqlInsert);
//            s.execute(sqlDelete);
//            s.execute(sqlUpdate);
//            s.executeUpdate(sqlInsert);
//            s.executeUpdate(sqlDelete);
//            s.executeUpdate(sqlUpdate);


            // 不同1：execute可以执行查询语句
            // 然后通过getResultSet，把结果集取出来
            String sqlSelect = "select * from hero";
            s.execute(sqlSelect);
            ResultSet rs = s.getResultSet();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
            }

            // executeUpdate不能执行查询语句
            // s.executeUpdate(sqlSelect); Can not issue SELECT via executeUpdate().

            // 不同2:
            // execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
            boolean isSelect = s.execute(sqlSelect);
            System.out.println(isSelect);

            // executeUpdate返回的是int,表示有多少条数据受到了影响
            String sqlUpdate = "update hero set hp=300 where id < 21000";
            int effectNumber = s.executeUpdate(sqlUpdate);
            System.out.printf("受到更新数据影响的数据量为%d条%n",effectNumber);



        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
