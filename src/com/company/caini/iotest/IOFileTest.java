package com.company.caini.iotest;

import java.io.*;

/**
 * Created by Batman on 2018/7/31.
 */
public class IOFileTest {
    public static void main(String[] args){
        //copyFile("/Users/Batman/JavaProjects/JavaStudy/data/Dog.txt", "/Users/Batman/JavaProjects/JavaStudy/data/cat.txt");
        //copyFolder("/Users/Batman/Desktop/ACL_titles_abstracts_dataset-master", "/Users/Batman/JavaProjects/JavaStudy/data/test");
        searchStrOfFolder("垃圾回收机制", "/Users/Batman/JavaProjects/JavaStudy/data/");

    }

    public static void copyFile(String srcFile, String descFile){

        // 缓存区
        byte[] buffer = new byte[1024];
        try(

                FileInputStream fis = new FileInputStream(srcFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream(descFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            while(true){
                // 实际读取的长度是actuallyReaded,有可能小于1024
                int actuallyReaded = bis.read(buffer);
                if(-1==actuallyReaded)
                    break;
                bos.write(buffer, 0, actuallyReaded);
                bos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFolder(String srcFolder, String descFolder){
        // 递归实现复制文件夹
        File f1 = new File(srcFolder);
        File f2 = new File(descFolder);
        if(!(f1.exists()))
            return;
        if(!(f1.isDirectory()) || f1.isFile())
            return;
        if(f2.isFile())
            return;
        if(!(f2.isDirectory()))
            f2.mkdirs();
        File[] lists = f1.listFiles();
        for(File f: lists){
            if(f.isFile()){
                File f3 = new File(descFolder, f.getName());  // 构造方法前面是父类文件夹, 后面是当前文件
                copyFile(f.getAbsolutePath(), f3.getAbsolutePath());
            }
            if(f.isDirectory()){
                File f3 = new File(descFolder, f.getName());
                copyFolder(f.getAbsolutePath(), f3.getAbsolutePath());
            }
        }
    }

    public static void searchStrOfFolder(String str, String targetFolder){
        File folders = new File(targetFolder);
        int findResultCount = 0;
        for(File f:folders.listFiles()){
            if(f.isDirectory())
                searchStrOfFolder(str, f.getAbsolutePath());
            else{
                try(
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        ){
                    char[] cs = new char[2048];
                    while(true){
                        int acturalReaded = br.read(cs);
//                        System.out.println("当前的缓存大小为:"+cs.length);
                        if(-1==acturalReaded)
                            break;
                        if (String.valueOf(cs).contains(str)) {
                            findResultCount += 1;
                            System.out.printf("找到目标字符串%s,所在文件为:%s%n", str, f.getAbsoluteFile());
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        if (findResultCount == 0)
            System.out.printf("在当前%s的目录下,没有找到%s的字符串", targetFolder, str);


    }
}
