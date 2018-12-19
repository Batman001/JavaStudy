package com.company.caini.jdbc;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunchao on 2018/10/25.
 * @author Batman
 * 设计类HeroDAO，实现接口DAO
 * 主要功能是获取数据库中关于JDBCHero的相关数据功能类
 */
public class HeroDAO implements DAO {
    public HeroDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sctest?characterEncoding=UTF-8", "root",
                "Newworld0707");

    }

    public int getTotal(){
        int total = 0;
        try(
                Connection c = getConnection();
                Statement s = c.createStatement();
        ){
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total = rs.getInt(1);
            }

            System.out.println("total" + total);


        }catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(JDBCHero hero) {

        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void update(JDBCHero hero) {

        String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.setInt(4, hero.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * 通过传入相关英雄的值进行更新sql中数据
     * @param heroName
     * @param heroHp
     * @param damage
     * @param id
     */
    public void update(String heroName, float heroHp, int damage, int id){
        String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, heroName);
            ps.setFloat(2, heroHp);
            ps.setInt(3, damage);
            ps.setInt(4, id);

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from hero where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public JDBCHero get(int id) {
        JDBCHero hero = null;

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new JDBCHero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.setName(name);
                hero.setHp(hp);
                hero.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<JDBCHero> listAllData() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<JDBCHero> list(int start, int count) {
        List<JDBCHero> heros = new ArrayList<>();

        String sql = "select * from hero order by id desc limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JDBCHero hero = new JDBCHero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);

                hero.setId(id);
                hero.setName(name);
                hero.setHp(hp);
                hero.setDamage(damage);
                heros.add(hero);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return heros;
    }

    public static void main(String[] args) {
        HeroDAO hd = new HeroDAO();
        System.out.println(hd.listAllData().size());

        JDBCHero h1 = new JDBCHero("毒液",100.0f,10);
        hd.add(h1);

        JDBCHero h2 = new JDBCHero("蜘蛛侠",100.0f,10);
        hd.add(h2);

        System.out.println(hd.listAllData().size());

        System.out.println(hd.list(1,2).toArray());

    }

}



