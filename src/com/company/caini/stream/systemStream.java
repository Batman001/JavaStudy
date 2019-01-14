package com.company.caini.stream;
import java.util.Scanner;
/**
 * Created by Batman on 2018/7/31.
 */
public class systemStream {
    public static void main(String[] args){

//        try(InputStream is = System.in){
//            while(true){
//                int i  = is.read();
//                System.out.println(i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scanner从控制台读取数据

//        Scanner s = new Scanner(System.in);
//        while(true){
//            System.out.println("请输入内容:");
//            String line = s.nextLine();
//            System.out.println(line);
//        }

        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println("第一个整数是" + a);
        int b = s.nextInt();
        System.out.println("第二个整数是" + b);

    }
}
