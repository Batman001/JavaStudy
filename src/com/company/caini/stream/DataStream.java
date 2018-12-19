package com.company.caini.stream;

import java.io.*;

/**
 * Created by sunchao on 2018/7/30.
 */
public class DataStream {
    public static void main(String[] args){
        wtite();
        read();
    }

    private static void read() {
        File f = new File("/Users/sunchao/JavaProjects/JavaStudy/data/dataStream.txt");
        try(
                FileInputStream fis = new FileInputStream(f);
                DataInputStream dis = new DataInputStream(fis);
                )
        {
            boolean b1 = dis.readBoolean();
            boolean b2 = dis.readBoolean();
            boolean b3 = dis.readBoolean();
            int i1 = dis.readInt();
            int i2 = dis.readInt();
            int i3 = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到布尔值:"+b2);
            System.out.println("读取到整数:" + i2);
            System.out.println("读取到字符串:" + str);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void wtite() {
        File f = new File("/Users/sunchao/JavaProjects/JavaStudy/data/dataStream.txt");
        try(
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
                ){
            dos.writeBoolean(true);
            dos.writeBoolean(false);
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeInt(400);
            dos.writeInt(500);
            dos.writeUTF("123 is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
