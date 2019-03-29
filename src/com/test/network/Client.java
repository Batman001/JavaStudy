package com.company.caini.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Batman on 2018/10/30.
 */
public class Client {
    public static void main(String[] args) {
        try{
            // 连接到本机的8888端口
            Socket s = new Socket("127.0.0.1", 8888);

            System.out.println(s);

            // 打开输出流
            OutputStream os = s.getOutputStream();
            // 把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);

            // 使用writeUTF发送字符串
//            dos.writeUTF("Legendaty");

            // 使用Scanner读取控制台的属兔,并发送到服务端
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            dos.writeUTF(str);
            dos.close();

            s.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
