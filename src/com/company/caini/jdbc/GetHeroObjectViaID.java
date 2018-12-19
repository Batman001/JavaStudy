package com.company.caini.jdbc;

import java.sql.*;

/**
 * Created by sunchao on 2018/10/24.
 * 根据ID返回一个对象
 * @author Batman
 */
public class GetHeroObjectViaID {

    public static JDBCHero get(int id){
        JDBCHero hero = null;
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
            String sql = "select * from hero where id = "+ id;
            ResultSet rs = s.executeQuery(sql);
            // 因为id是唯一的，ResultSet最多只能有一条记录
            // 所以使用if代替while
            if(rs.next()){
                hero = new JDBCHero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.setName(name);

                hero.setHp(hp);
                hero.setDamage(damage);
                hero.setId(id);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hero;
    }


    public static void main(String[] args) {
        JDBCHero hero = get(24000);
        System.out.println(hero);
        System.out.println(hero.getName());

    }
}
