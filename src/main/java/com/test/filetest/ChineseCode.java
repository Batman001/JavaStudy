package com.test.filetest;

import java.io.*;

/**
 * Created by Batman on 2018/7/27.
 */
public class ChineseCode {
    public static void main(String[] args){
        //String str = "中";
        //showCode(str);

        File f = new File("/Users/Batman/Desktop/BatmanInfo.txt");
        try(FileInputStream fis = new FileInputStream(f)){
            byte[] all = new byte[(int) f.length()];
            fis.read(all);

            // 从文件读出来的数据是
            System.out.println("从文件中读出来的数据是: ");
            for(byte b:all){
                int i = b&0X000000ff;
                System.out.println(Integer.toHexString(i));
            }

            System.out.println("把这个数字,放在GBK的棋盘上去:");
            String str = new String(all, "UTF-8");
            System.out.println(str);


        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    private static void showCode(String str) {
        String[] encodes = {"BIG5", "GNK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for(String encode:encodes){
            showCode(str, encode);
        }
    }

    private static void showCode(String str, String encode) {
        try{
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);
            for(byte b:bs){
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.printf("UnsupportedEncodingException : %s编码方式无法解析字符%s%n", encode, str);
        }
    }
}
