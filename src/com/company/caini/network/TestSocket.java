package com.company.caini.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sunchao on 2018/10/29.
 * @author Batman
 */
public class TestSocket {
    public static void main(String[] args) throws UnknownHostException,IOException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机IP地址是" + ip);

        // java String构造函数 对字符串进行切割操作
        System.out.println(new String(ip.toCharArray(), 0, 10));

        /**
        Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            if(line.length() != 0){
                sb.append(line + "\r\n");
            }
        }
        System.out.println("本次指令返回的消息是:");
        System.out.println(sb.toString());
*/
    }
}
