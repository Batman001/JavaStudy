package com.test.network.chatRobotThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Batman on 2018/10/30.
 * @author Batman
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server正在监听端口8888");
            Socket s = ss.accept();

            // 启动发送消息线程
            new SendThread(s).start();
            // 启动接收消息线程
            new ReceiveThread(s).start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
