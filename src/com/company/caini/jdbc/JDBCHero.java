package com.company.caini.jdbc;

/**
 * Created by sunchao on 2018/10/24.
 * @author Batman
 */
public class JDBCHero {
    // 增加ID属性
    private int id;
    private String name;
    private float hp;
    private int damage;


    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHp(float hp){
        this.hp = hp;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public String getName(){
        return this.name;
    }
    public float getHp(){
        return this.hp;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getId(){
        return this.id;
    }

    public JDBCHero(String name, float hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public JDBCHero(int id, String name, float hp, int damage){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    public JDBCHero(){}
}
