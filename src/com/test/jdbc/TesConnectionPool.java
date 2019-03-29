package com.company.caini.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Batman on 2018/10/26.
 * @author Batman
 */
public class TesConnectionPool {

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for (int i=0;i<100;i++){
            new WorkingThread("working thread" + i, cp).start();
        }
    }
}

class WorkingThread extends Thread{


    private ConnectionPool cp;

//    public ConnectionPool getCp() {
//        return cp;
//    }

    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }

    @Override
    public void run(){
        Connection c = cp.getConnection();
        System.out.println(this.getName()+":\t获得了一根连接,并开始工作");
        try(Statement s = c.createStatement()){
            // 模拟耗时一秒的SQL操作
            String selectSql = "select * from hero";
            Thread.sleep(1000);
            s.execute(selectSql);

        }catch(SQLException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
