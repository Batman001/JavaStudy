package com.test.filetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Batman on 2018/10/9.
 * @author Batman
 */
public class FileSearch {

    /**
     * @author Batman
     * @param file  查找的目录
     * @param search  查找的字符串
     */
    public static void search(File file, String search){
        if(file.isFile()){
            if(file.getName().toLowerCase().endsWith(".java")){
                String fileContent = readFileContent(file);
                if(fileContent.contains(search)){
                    System.out.printf("找到子目标字符串%s,在文件:%s%n", search, file);
                }
            }
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f:fs){
                search(f, search);
            }
        }


    }

    private static String readFileContent(File file) {
        try(FileReader fr = new FileReader(file)){
            char[] all = new char[(int) file.length()];
            fr.read(all);
//            System.out.println(all);
            return new String(all);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        File folder = new File("/Users/Batman/JavaProjects/JavaStudy");
        search(folder, "fuck");

    }
}
