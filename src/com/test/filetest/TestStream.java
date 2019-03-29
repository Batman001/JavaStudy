package com.company.caini.filetest;

import java.io.*;

/**
 * Created by Batman on 2018/7/27.
 */
public class TestStream {
    public static void main(String[] args){
        try{
            File f = new File("/Users/Batman/Desktop/BatmanInfo.txt");
            // 创建基于文件的输入流
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(f);

            byte[] data = {78,79};
            fos.write(data);
            fos.close();
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for(byte b: all){
                System.out.println(b);
            }
            fis.close();

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
