package com.company.caini.filetest;
import java.io.File;
/**
 * Created by Batman on 2018/7/27.
 */
public class FileTest {
    File f;
    public FileTest(File file){
        this.f = file;
    }
    long maxsize = 0;
    long minsize = Long.MAX_VALUE;
    File maxfile = null;
    File minfile = null;


    /**
     * 递归实现查找某个目录下最大的文件以及最小的文件
     * @param f(传入路径信息)
     * 递归实现查找功能
     */
    public void find(File f){
        File[] fs = f.listFiles();
        if (fs == null){
            return;
        }
        for(File each : fs){
            if(each.isFile()){
                if(each.length() > maxsize){
                    maxsize = each.length();
                    maxfile = each;
                }
                if(each.length()<minsize && each.length() !=0){
                    minsize = each.length();
                    minfile = each;
                }
            }
            if(each.isDirectory()){
                find(each);
            }
        }
    }


    public static void main(String[] args){
        String filepath = "/Users/Batman/Movies";
        File test = new File(filepath);
        FileTest ft = new FileTest(test);
        ft.find(test);
        System.out.println("当前路径"+filepath+"下,最大文件是"+ft.maxfile + " 其文件大小为"+ ft.maxsize);
        System.out.println("当前路径"+filepath+"下,最小文件是"+ft.minfile + " 其文件大小为"+ ft.minsize);
    }
}
