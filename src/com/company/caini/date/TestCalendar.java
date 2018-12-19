package com.company.caini.date;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import static com.sun.tools.javac.util.Constants.format;

/**
 * Created by sunchao on 2018/7/17.
 */
public class TestCalendar {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    public static void main(String[] agrs){
        Calendar c = Calendar.getInstance();  // 采用单例模式获取日历对象Calendar.getInstance()

        // 当前日期
        Date now = c.getTime();
        System.out.println("当前日期为:" + sdf.format(c.getTime()));

        // 下个月的今天
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天是:"+sdf.format(c.getTime()));

        // 去年的今天
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("去年的今天是" + sdf.format(c.getTime()));

        // 上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.add(Calendar.DATE, 3);
        System.out.println("上个月的今天的后三天是:" + sdf.format(c.getTime()));

    }




}
