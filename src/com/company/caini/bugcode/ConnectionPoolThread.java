package com.company.caini.bugcode;
import com.company.caini.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created on 2018/10/26.
 * @author Batman
 * Wrong Code
 */
public class ConnectionPoolThread {

    int threadCount;
    int connectionPoolSize;
    public ConnectionPoolThread(int threadCount, int connectionPoolSize){
        this.threadCount = threadCount;
        this.connectionPoolSize = connectionPoolSize;

    }

    public void insertData(){
        for(int i=0;i<threadCount;i++){
            new ConnectionPoolWorkingThread(
                    "ConnectionPoolWorkingThread" + i, new ConnectionPool(10)).start();
        }
    }

}
class ConnectionPoolWorkingThread extends Thread{
    private ConnectionPool cp;

    public ConnectionPoolWorkingThread(String name, ConnectionPool cp){
        super(name);
        this.cp = cp;
    }

    @Override
    public void run(){
        Connection c = cp.getConnection();
        String insertSql = "insert into hero values(null,?,?,?)";
        try{
            PreparedStatement ps = c.prepareStatement(insertSql);
            ps.setString(1, "猪八戒");
            ps.setFloat(2, 120.f);
            ps.setInt(3, 18);
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
