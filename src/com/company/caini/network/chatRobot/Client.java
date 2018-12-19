package com.company.caini.network.chatRobot;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sunchao on 2018/10/30.
 * @author Batman
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                dos.writeUTF(str);
                String msg = dis.readUTF();
                System.out.println(msg);
                System.out.println();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
