package com.test.stream;

import java.io.*;

/**
 * Created by Batman on 2018/7/30.
 */
public class DataStreamTest {
    public static void main(String[] args){
        // 缓存流式处理
        File f1 = new File("/Users/Batman/JavaProjects/JavaStudy/data/1.txt");
        try{
            FileWriter fw = new FileWriter(f1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("31@32@34");
            bw.flush();
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            String s = "";
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(Character.isDigit(ch))
                    s += ch;
                else{
                    System.out.println("读取到一个数字为:"+Integer.parseInt(s));
                    s= "";
                }

            }
            System.out.println("读取到一个数字:" + Integer.valueOf(s));
        }
        catch(IOException e){
            e.printStackTrace();
        }


        // 数据流式处理
        File f2 = new File("/Users/Batman/JavaProjects/JavaStudy/data/2.txt");
        try{
            FileOutputStream fos= new FileOutputStream(f2);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(31);
            dos.writeInt(32);
            dos.writeInt(56);

            FileInputStream fis = new FileInputStream(f2);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println("从文件中读取到一个数字是 : "+ dis.readInt());
            System.out.println("从文件中读取到一个数字是 : "+ dis.readInt());
            System.out.println("从文件中读取到一个数字是 : "+ dis.readInt());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("路径出现错误,请好好检查路径信息");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

