package com.company.caini.date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Batman on 2018/7/17.
 */
public class TestDate {
    public static void main(String[] args){
        Date d1 = new Date();
        System.out.println("当前时间是:");
        System.out.println(d1);
        System.out.println();

        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0份0秒, 开始经历了5秒的时间");
        System.out.println(d2);
        System.out.println();


        Date now = new Date();
        // 打印当前时间
        System.out.println("当前时间是:"+now.toString());
        System.out.println("当前时间getTIme()的返回的值是:" + now.getTime());

        Date zero = new Date(0);
        System.out.println("用0作为构造方法,得到的日期是:" + zero);
        System.out.println();


        //当前日期的毫秒数
        System.out.println("date.getTime() \t\t\t返回值为:" + now.getTime());
        // 通过system.currentTimeMillis() 获取当前日期毫秒数
        System.out.println();
        System.out.println("System.currentTimeMillis() \t\t\t返回值为:"+ System.currentTimeMillis());


        System.out.println();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str = "2018/07/12 12:28:30";
        try{
            Date d = sdf.parse(str);
            System.out.printf("字符串 %s 通过格式 yyyy/MM/dd HH:mm:ss %n转换成日期对象为:%s", str,d.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
