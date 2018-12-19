package com.company.caini.jdbc;
import java.util.List;

/**
 * Created by sunchao on 2018/10/25.
 * @author Batman
 */
public interface DAO {
    // 增加
    public void add(JDBCHero hero );
    // 修改
    public void update(JDBCHero hero);
    // 删除
    public void delete(int id);
    // 获取
    public JDBCHero get(int id);
    // 查询
    public List<JDBCHero> listAllData();
    // 分页查询
    public List<JDBCHero> list(int start, int end);


}

