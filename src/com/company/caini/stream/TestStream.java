package com.company.caini.stream;


import java.io.*;

/**
 * Created by Batman on 2018/7/30.
 */
public class TestStream {
    public static void main(String[] args){
        File f = new File("/Users/Batman/JavaProjects/JavaStudy/data/BatmanInfo.txt");

        try(
                // 创建文件字符流
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr))
        {
            while (true){
                String line = br.readLine();
                if(null == line)
                    break;
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // PrintWriter缓存字符输出流 可以一次写出一行数据

        try(
                // 创建文件字符流
                FileWriter fw = new FileWriter(f,true);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw))
        {
            pw.println("姓名：孙超 \n" +
                    "身份证号：131127199310153296 \n" +
                    "手机号：18801003216 \n" +
                    "户籍地址：河北省衡水市景县降河流镇刘岳庄 \n" +
                    "户籍邮编：053500\n" +
                    "现住地址：北京市丰台区丰卉家园3号楼6单元301\n" +
                    "现住邮编：100070");
            pw.println("定点医院：\n" +
                    "（1）中国人民解放军总医院\n" +
                    "（2）中国人民解放军空军总医院\n" +
                    "（3）北京丰台医院\n" +
                    "（4）武警北京市总队第三医院\n" +
                    "（5）北京市丰台区卢沟桥社区卫生服务中心");
        }
        catch(IOException e){
            e.printStackTrace();
        }


        /*
        如果有时候,需要立即把数据写入到硬盘,而不是等缓存满了以后才写出去,这时候需要用到flush
         */
        // 向桌面文件lol2.txt文件中写入三句话
        // File 创建时 如果指定目录里没有,java虚拟机会自动创建一个
        File f1 = new File("/Users/Batman/JavaProjects/JavaStudy/data/lol2.txt");
        try(
                FileWriter fw = new FileWriter(f1);
                PrintWriter pw = new PrintWriter(fw)
                ){
            pw.println("garen kill teemo");
            // 强制把缓存中的数据写入硬盘,无论缓存是否已满
            pw.flush();
            pw.println("teemp revive after 1 mintutes");
            pw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
