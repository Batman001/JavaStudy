package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by sunchao on 2018/10/23.
 */
public class AutoIncrement {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String addSql = "insert into hero values(null,?,?,?)";
        try(Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8",
                "root", "Newworld0707");
            PreparedStatement ps =
                    c.prepareStatement(addSql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, "getId");
            ps.setFloat(2, 666.0f);
            ps.setInt(3, 999);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            Integer preId = null;
            if(rs.next()){
                int id = rs.getInt(1);
                System.out.println("插入一条数据,本次数据的ID是:" + id);
                preId = id - 1;
            }
            while(true){
                String delSql = "delete from hero where id=" + preId;
                String checkSql = "select * from hero where id=" + preId;
                ResultSet rs2 = ps.executeQuery(checkSql);
                boolean next = rs2.next();
                if(next){
                    System.out.println("上一条数据id: " + preId+ "是否存在:" + next);
                    System.out.println("上一条数据存在,执行删除操作.......");
                    ps.execute(delSql);
                    System.out.println("删除操作成功....");
                    break;
                }
                else{
                    System.out.println("上一条数据id："+preId+",是否存在:"+next);
                    preId-=1;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
