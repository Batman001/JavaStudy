package com.test.date;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Created by Batman on 2018/7/17.
 */
public class DateSort {
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

    public static void main(String[] args) throws ParseException{
        String[] dateArray = new String[9];
        String start = "1970.01.01 00:00:00";
        String end = "2000.12.31 23:59:59";
        long d = DateRandom.time(end) - DateRandom.time(start);


        long difference = d;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        for(int i=0;i<dateArray.length;i++){
            long randomDate = (long)(Math.random() * difference + DateSort.time(start));
            Date d1 = new Date(randomDate);
            dateArray[i] = sd.format(d1);
        }

        System.out.println("得到随机日期数组为:");
        for(int i=0;i<dateArray.length;i++){
            System.out.println(dateArray[i]);
        }

        Arrays.sort(dateArray);
        System.out.println("排序后随机日期数组为:");
        for (int i=0;i<dateArray.length;i++){
            System.out.println(dateArray[i]);
        }

    }
}
