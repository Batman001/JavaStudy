package com.company.caini.date;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Created by sunchao on 2018/7/17.
 *
 */
public class DateRandom {
    public static long time(String s){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        try{
            return sdf.parse(s).getTime();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args){
        String start = "1995.1.1 00:00:00";
        String end = "1995.12.31 23:59:59";

        long d = DateRandom.time(start) - DateRandom.time(end);
        System.out.println(d);
        long s = DateRandom.time(end);
        System.out.println(s);
        long t = s + (long)(Math.random() * d);
        System.out.println(t);
        Date sd = new Date(t);
        System.out.println(sd);

    }
}
