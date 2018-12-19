package com.company.caini.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sunchao on 2018/10/26.
 * @author Batman
 */
public class ConnectionpoolWorkingThread extends Thread{
    private ConnectionPool cp;

    public ConnectionpoolWorkingThread(ConnectionPool cp){
        this.cp = cp;
    }

    @Override
    public void run(){
        String insertSql = "insert into hero values(null,?,?,?)";
        Connection c = cp.getConnection();
        try(PreparedStatement ps = c.prepareStatement(insertSql)){
            for(int i = 0; i < TestConnectionPoolAndTraditionConnection.insertTime; i++){
                ps.setString(1, "孙悟空");
                ps.setFloat(2, 300.0f);
                ps.setInt(3, 19);
                ps.execute();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        cp.returnConnection(c);

   }
}
