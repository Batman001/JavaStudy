package com.company.caini.network.chatRobotThread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sunchao on 2018/10/30.
 * @author Batman
 */
public class SendThread extends Thread{
    private Socket s;
    public SendThread(Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        try{
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }
}
