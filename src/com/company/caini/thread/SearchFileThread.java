package com.company.caini.thread;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sunchao on 2018/10/9.
 * @author sunchao
 */


public class SearchFileThread extends Thread{
    private File file;
    private String search;

    public SearchFileThread(File file, String search){
        this.file = file;
        this.search = search;
    }

    @Override
    public void run(){
        String fileSearchContent = readFileContent(file);
        assert fileSearchContent != null;
        if(fileSearchContent.contains(search)){
            System.out.printf("找到目标字符串%s,文件为:%s%n", search, file);

        }
    }

    private String readFileContent(File file) {
        try {
            FileReader fr = new FileReader(file);
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
