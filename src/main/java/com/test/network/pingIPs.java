package com.test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Batman on 2018/10/29.
 * 判断本网段有多少可用的ip地址
 * @author Batman
 */
public class pingIPs {
    static int count = 0;
    public static void main(String[] args) throws UnknownHostException,IOException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        StringBuilder sb1 = new StringBuilder();
        String baseIp = new String(ip.toCharArray(), 0, 10);

        for (int i = 0; i <= 255; i++) {
            // 这里ping指令 只ping一次, 1秒超时
            Process p = Runtime.getRuntime().exec("ping " + baseIp + i + " -c 1 -t 1");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0) {
                    sb.append(line);
                }
            }
            if(null != sb && sb.toString().equals("")){
                String longString = "";
                if(sb.toString().indexOf("TTL") > 0){
                    sb1.append("ping " + baseIp + i);
                }else{
                    System.out.println("ping " + baseIp + i + "无法ping通");
                }
            }
            System.out.println("以下可以Ping通");
            System.out.println(sb.toString());
        }

    }
}
