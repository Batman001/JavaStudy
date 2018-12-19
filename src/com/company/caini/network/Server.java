package com.company.caini.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunchao on 2018/10/30.
 * @author Batman
 */
public class Server {
    public static void main(String[] args) {
        try{
            // 服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
            // 在8888端口上监听, 看是否有连接请求过来
            System.out.println("监听端口号:8888");
            Socket s = ss.accept();

            // 打开输入流
            InputStream is = s.getInputStream();


            // 把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            // 使用readUTF读取字符串
            String msg = dis.readUTF();


            // 打印出来
            System.out.println("从客户端读取数据为: "+msg);
            is.close();

            System.out.println("有连接过来" + s);

            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
