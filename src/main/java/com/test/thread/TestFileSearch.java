package com.test.thread;
import java.io.File;
/**
 * Created by Batman on 2018/10/9.
 * @author Batman
 */
public class TestFileSearch {
    public static void search(File file, String search){
        if(file.isFile()){
            if(file.getName().toLowerCase().endsWith(".java")){
                new SearchFileThread(file, search).start();
            }
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            assert fs != null;
            for(File f:fs){
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File folder = new File("/Users/*****/JavaProjects/JavaStudy");
        search(folder, "attack");
    }
}
