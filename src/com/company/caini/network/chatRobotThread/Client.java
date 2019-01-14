package com.company.caini.network.chatRobotThread;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Batman on 2018/10/30.
 * @author Batman
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("127.0.0.1", 8888);

            // 启动接收消息线程
            new ReceiveThread(s).start();
            // 启动发送消息线程
            new SendThread(s).start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

