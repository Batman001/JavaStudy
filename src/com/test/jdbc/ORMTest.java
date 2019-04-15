package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Batman on 2018/10/24.
 * @author Batman
 */
public class ORMTest {

    /**
     * 把一个Hero对象插入到数据库中
     * @param hero : 待添加进数据库的对象
     */
    public static void add(JDBCHero hero){
        JDBCUtil db = new JDBCUtil();
        String addSql="insert into hero values(null,?,?,?)";
        try(
                Connection c = db.getCon();
                PreparedStatement ps = c.prepareStatement(addSql);
        ){
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从数据库中删除一个对象
     * @param hero 要删除对象的信息
     */
    public static void delete(JDBCHero hero){
        JDBCUtil db = new JDBCUtil();
        String deleteSql = "delete from hero where id=?";
        try(Connection c = db.getCon();
            PreparedStatement ps = c.prepareStatement(deleteSql);){
            ps.setInt(1, hero.getId());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 更新数据库中某一条数据
     * @param hero
     */
    public static void update(JDBCHero hero){
        JDBCUtil db = new JDBCUtil();
        String updateSql = "update hero set name=?,hp=?,damage=? where id=?";
        try(Connection c = db.getCon();
            PreparedStatement ps = c.prepareStatement(updateSql)){
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.setInt(4, hero.getId());

            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
     */
    public static List<JDBCHero> listAllData(){
        JDBCUtil db = new JDBCUtil();
        String selectSql="select * from hero";
        List<JDBCHero>list=new LinkedList<>();
        try(Connection c = db.getCon();
            PreparedStatement ps = c.prepareStatement(selectSql);
                ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                JDBCHero currentHero = new JDBCHero();
                currentHero.setId(rs.getInt(1));
                currentHero.setName(rs.getString(2));
                currentHero.setHp(rs.getFloat(3));
                currentHero.setDamage(rs.getInt(4));
                list.add(currentHero);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        List<JDBCHero> list = listAllData();
        System.out.println("当前list中数据为" + list.size() + "条");
        JDBCHero add1 = new JDBCHero("狄仁杰",100.0f,23);
        add(add1);
        list = listAllData();
        System.out.println("当前list中数据为" + list.size() + "条");


        //测试update功能
        JDBCHero up1 = new JDBCHero(23576, "Annie", 200.0f, 12);
        update(up1);

        //测试delete功能
        delete(up1);

    }
}
