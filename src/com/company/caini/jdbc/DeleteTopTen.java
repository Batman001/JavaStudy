package com.company.caini.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by sunchao on 2018/10/23.
 * @author Batman
 */
public class DeleteTopTen {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "Newworld0707";

    public static void main(String[] args) {
        try{
            Class.forName(JDBC_DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement s = c.createStatement();

        ) {
            // 查询当前数据库id信息
            String selectId = "select id from hero";
            ResultSet rs = s.executeQuery(selectId);

            // 得到当前数据库的前十条数据的id信息
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while(rs.next() && count < 1000){
                sb.append(rs.getInt("id") + "\t");
                count += 1;
            }
            String[] idS = sb.toString().split("\t");


            c.setAutoCommit(false);
            String delSql = "delete from hero where id=?";
            PreparedStatement ps = c.prepareStatement(delSql);
            for(int i = 0;i < 1000;i++){
                ps.setInt(1,Integer.parseInt(idS[i]));
                ps.execute();
            }
            Scanner input = new Scanner(System.in);
            boolean flag = false;
            while(!flag){
                System.out.println("是否要删除数据? (Y/N)");
                String str = input.nextLine();
                if("Y".equalsIgnoreCase(str)){
                    c.commit();
                    System.out.println("提交删除事务,删除前十条数据");
                    flag = true;
                }
                else if("N".equalsIgnoreCase(str)){
                    System.out.println("取消删除！");
                    flag=true;
                }

            }
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }



}
