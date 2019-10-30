package com.test.thread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Batman on 2018/10/17.
 * 借助线程池同步查找文件内容
 * @author Batman
 */
public class TestFileSearchThreadPool {

    File file;
    String search;

    public TestFileSearchThreadPool(File file, String search){
        this.file = file;
        this.search = search;
    }

    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>());


    public void search(File file, String search){
        if(file.isFile() && file.getName().toLowerCase().endsWith(".java")){
            threadPool.execute(new Runnable(){
                @Override
                public void run(){
                    try {
                        FileReader fr = new FileReader(file);
                        char[] ch = new char[(int) file.length()];
                        fr.read(ch);
                        String str = new String(ch);
                        if(str.contains(search)){
                            System.out.printf("找到目标字符串%s,文件为:%s%n", search, file);
                        }
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f:fs){
                search(f, search);
            }
        }

    }

    public static void main(String[] args) {

        File file = new File("/Users/Batman/JavaProjects/JavaStudy");
        String search = "attack";
        TestFileSearchThreadPool ts = new TestFileSearchThreadPool(file, search);
        ts.search(file, search);


    }
}
