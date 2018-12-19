package com.company.caini.filetest;
import java.io.*;

/**
 * Created by sunchao on 2018/7/27.
 */
public class SplitMergeFile {
    private static final int KBNUMBER=100;
    public static void main(String[] args){
        File f = new File("/Users/sunchao/JavaProjects/JavaStudy/data/testMusic.mp3");
        splitFile(f);
        //System.out.println(f.getName().substring(0,f.getName().lastIndexOf(".")));
        //System.out.println(f.getName().substring(f.getName().lastIndexOf("."), f.getName().length()));
        File mf = new File("/Users/sunchao/JavaProjects/JavaStudy/datasplitFile");
        merge(mf);
    }

    private static void merge(File mf) {
        if(mf == null)
            System.out.println("合并文件路径为空");
        if(!mf.exists())
            System.out.println("合并的子文件不存在");
        File f = new File(mf.getAbsoluteFile() + "/merge.mp3");
        File[] fList = mf.listFiles();
        try(
            FileOutputStream fos = new FileOutputStream(f)){
            // 判断文件后缀是否为mp3
            for(File each: fList)
                if ("mp3".equals(each.getName().substring(each.getName().lastIndexOf(".") + 1))) {
                    // 使用try() 方式关闭流
                    // 将流的定义在try()里面,在完成时会自动关闭
                    try(FileInputStream fis = new FileInputStream(each)){
                        byte[] b = new byte[(int) each.length()];
                        fis.read(b);
                        fos.write(b);
                    }

                }
            System.out.println("文件合并完成!,合并后的文件名称为:"+f.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void splitFile(File f) {
        if(f==null)
            System.out.println("拆分的文件为空");

        if(!f.exists())
            System.out.println("拆分的文件不存在");

        File dir = new File(f.getParent() + "splitFile");  // 创建新的目录用于存放切割子文件
        dir.mkdirs();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File[] sf = new File[(int) (f.length() / KBNUMBER / 1024) + 1];
        String filename = f.getName().substring(0, f.getName().lastIndexOf("."));  // 文件后缀前部分
        String suffixname = f.getName().substring(f.getName().lastIndexOf("."), f.getName().length()); // 文件后缀
        try{
            fis = new FileInputStream(f);
            for(int i=0;i<sf.length - 1;i++){
                sf[i] = new File(dir.getAbsoluteFile() + "/" + filename + "_" + i + suffixname);
                fos = new FileOutputStream(sf[i]);
                byte[] b = new byte[1024 * KBNUMBER];
                fis.read(b);
                fos.write(b);
                System.out.println(sf[i].getAbsoluteFile() + "拆分并写入完成");
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        标准关闭文件数据流的方式
        (1)首先把流的引用生命在try的外面,如果声明在try里面,其作用域无法抵达finally
        (2)在finally关闭之前,要先判断该引用是否为空
        (3)关闭的时候,需要再再一次进行try catch处理
         */
        finally {
            if(fis != null){
                try{
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try{
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
