package com.company.caini.exceptiontest;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Batman on 2018/7/26.
 */
public class TestException2 {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        // OutOfMemoryError 耗光内存
//        for(int i=0;i<Integer.MAX_VALUE;i++){
//            sb.append("a");
        File f = new File("/Users/Batman/Desktop/personInfo.tx");
        try{
            new FileInputStream(f);
        }
        catch(Throwable t){
            t.printStackTrace();
            System.out.println("路径出现错误,请注意检查路径");
        }
        finally {
            System.out.println("无论如何,老子的程序就是要运行起来");
        }
    }
}
