package com.test.exceptiontest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Batman on 2018/7/26.
 */
public class TestException {
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("/Users/Batman/Desktop/personInfo");
        try{
            System.out.println("尝试打开桌面文件");
            new FileInputStream(f);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2018-07-26");
            System.out.println(d);
        }
        catch(FileNotFoundException | ParseException e){
            if (e instanceof FileNotFoundException)
                System.out.println("文件不存在");
            if (e instanceof ParseException)
                System.out.println("日期格式解析错误");
            e.printStackTrace();
        }
        finally{
            System.out.println("无论文件是否存在， 都会执行的代码");
        }
    }
}
