package com.company.caini.bugcode;

import com.company.caini.jdbc.HeroDAO;
import com.company.caini.jdbc.JDBCHero;

/**
 * Created by sunchao on 2018/10/26.
 * @author Batman
 * Wrong Code
 */
public class TraditionConnectionThread {

    int threadCount;

    public TraditionConnectionThread(int threadCount){
        this.threadCount = threadCount;
    }

    public void insertData(){
        for(int i=0;i<threadCount;i++){
            new TraditionWorkingThread("TraditionThread" + i).start();
        }
    }
}
class TraditionWorkingThread extends Thread{

    public TraditionWorkingThread(String name) {
        super(name);
    }
    @Override
    public void run(){
        HeroDAO hd = new HeroDAO();
        hd.add(new JDBCHero("孙悟空",155.0f,29));
    }
}
