package com.company.caini.network.chatRobotThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by sunchao on 2018/10/30.
 */
public class ReceiveThread extends Thread{
    private Socket s;

    public ReceiveThread(Socket s){
        this.s = s;
    }
    @Override
    public void run(){
        try{
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while(true){
                String msg = dis.readUTF();
                System.out.println(msg);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
