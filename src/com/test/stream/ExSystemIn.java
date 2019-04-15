package com.test.stream;

import java.io.*;
import java.util.Scanner;
/**
 * Created by Batman on 2018/7/31.
 */
public class ExSystemIn {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入类名:");
        String className = s.nextLine();
        System.out.println("请输入属性类别:");
        String type = s.nextLine();
        System.out.println("请输入属性名称:");
        String attName = s.nextLine();
        getFile(className, type, attName);
        System.out.println("名为"+className+".java文件已经生成,存储于桌面文件"+className+".java");

    }

    private static void getFile(String className, String type, String attName) {
        File f1 = new File("/Users/Batman/JavaProjects/JavaStudy/data/"+className+".java");
        File f2 = new File("/Users/Batman/JavaProjects/JavaStudy/data/"+className+".txt");

        try(
                FileReader fr = new FileReader(f2);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(f1);
                BufferedWriter bw = new BufferedWriter(fw)
                ){

            // 打印模板文件内容
            System.out.println("创建类的模板文件是:");
            String read = "";
            while(true){
                String s = br.readLine();
                if(s != null)
                    read += s + "\r\n";
                else
                    break;
            }

            System.out.println(read);

            System.out.println("-----------*********------------");
            String write = read.replaceAll("@class@", className);
            write = write.replaceAll("@type@", type);
            write = write.replaceAll("@property@", attName);

            char[] c = attName.toCharArray();
            if(c[0] >= 'a' && c[0] <= 'z'){
                c[0] = (char)(c[0] - 32);
            }

            attName = new String(c);
            write = write.replace("@Uproperty@", attName);
            System.out.println(write);
            bw.write(write);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
