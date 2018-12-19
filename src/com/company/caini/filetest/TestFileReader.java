package com.company.caini.filetest;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by sunchao on 2018/7/27.
 */
public class TestFileReader {
    public static void main(String[] args){
        File f = new File("/Users/sunchao/Desktop/sunchaoInfo.txt");
        System.out.println("默认的编码方式是:"+ Charset.defaultCharset());

        try(FileReader fr = new FileReader(f)){
            char[] cs = new char[(int) f.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是:%n",Charset.defaultCharset());
            System.out.println(new String(cs));

        }
        catch(IOException e){
            e.printStackTrace();

        }

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))){
            char[] cs = new char[(int) f.length()];
            isr.read(cs);
            System.out.println("InputStreamReader指定的编码方式UTF-8,识别出来的自复是:%n");
            System.out.println(new String(cs));
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
