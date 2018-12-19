package com.company.caini.thread;
import java.io.File;
/**
 * Created by sunchao on 2018/10/9.
 * @author sunchao
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
        File folder = new File("/Users/sunchao/JavaProjects/JavaStudy");
        search(folder, "attack");
    }
}
