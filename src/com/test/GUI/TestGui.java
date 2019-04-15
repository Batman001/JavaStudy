package com.test.GUI;

import javax.swing.*;
import java.io.*;

/**
 * Created by Batman on 2018/10/26.
 * @author Batman
 */
public class TestGui {


    public static void main(String[] args) {

        int winX = 200;
        int winY = 200;
        //主窗口
        JFrame f = new JFrame("LOL");

        //窗口大小
        f.setSize(800, 600);

        //从文件中获取坐标
        File zuobiao = new File("/Users/Batman/JavaProjects/JavaStudy/data/lolconfig.txt");

        if(zuobiao.exists()){
            try {
                FileReader fr = new FileReader(zuobiao);
                BufferedReader br = new BufferedReader(fr);
                try {
                    winX = Integer.parseInt(br.readLine());
                    winY = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        //主窗口的位置
        f.setLocation(winX,winY);

        //主窗口中组建的定位方式
        f.setLayout(null);

        //按钮组件
        JButton b = new JButton("对方基地一键爆炸");

        //设置按钮大小及位置
        b.setBounds(300,50,200,30);

        f.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        Thread t = new Thread(){
            @Override
            public void run(){
                while (true) {
                    System.out.println(f.getX() +" "+ f.getY());
                    Integer x = f.getX();
                    Integer y = f.getY();

                    //要保存的地址
                    File f = new File("/Users/Batman/JavaProjects/JavaStudy/data/lolconfig.txt");

                    FileWriter fw;
                    try {
                        fw = new FileWriter(f);
                        //使用缓存流保存地址
                        PrintWriter pw = new PrintWriter(fw);
                        pw.println(x);
                        pw.println(y);

                        pw.flush();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}