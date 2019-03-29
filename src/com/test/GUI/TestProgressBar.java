package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by Batman on 2018/11/13.
 * 设计一个线程，每隔100毫秒，就把进度条的进度+1。
 * 从0%一直加到100%
 * 刚开始加的比较快，以每隔100毫秒的速度增加，随着进度的增加，越加越慢，让处女座的使用者，干着急
 */
public class TestProgressBar {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setValue(0);
        pb.setStringPainted(true);

        new Thread(){
            @Override
            public void run(){
                int sleep = 100;
                for(int i=0;i<100;i++){
                    pb.setValue(i+1);
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        f.add(pb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
