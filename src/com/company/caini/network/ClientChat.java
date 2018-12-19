package com.company.caini.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sunchao on 2018/10/30.
 * @author Batman
 */
public class ClientChat {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1",8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
                String msg = dis.readUTF();
                System.out.println("收到服务端信息" + msg);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

