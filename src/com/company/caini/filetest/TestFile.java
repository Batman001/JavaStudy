package com.company.caini.filetest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Arrays;

/**
 * Created by sunchao on 2018/7/27.
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        File f1 = new File("/Users/sunchao/Desktop");
        System.out.println("f1的绝对路径:"+f1.getAbsolutePath());
        File f2 = new File(f1,"personInfo.txt");
        System.out.println("f2的绝对路径是" + f2.getAbsolutePath());
        File f3 = new File(f1, "stock.csv");
        System.out.println("f3的绝对路径是" + f3.getAbsolutePath());


        System.out.println("判断是否存在:" + f3.exists());

        System.out.println("判断是否是文件夹:" + f1.isDirectory());

        System.out.println("判断是否为文件:" + f2.isFile());

        System.out.println("获取文件的长度:" + f3.length());

        // 文件最后修改时间
        long time = f3.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件最后的修改时间是:" + d);
        // 设置文件修改的时间为1970.1.1 08:00:00
        f1.setLastModified(0);

        // 文件重命名
        f2.renameTo(new File(f1, "sunchaoInfo.txt"));
        System.out.println("修改后f2的路径为" + f2.getAbsolutePath());

        /*
        文件操作常用方法测试
         */
        // 以字符串数组的形式 返回当前文件夹下的所有文件(不包含子文件及子文件夹)
        System.out.println(Arrays.toString(f1.list()));  // 打印字符串数组的方法
        // 以文件数组形式,返回当前文件夹下的所有文件(不包含子文件及子文件夹)
        File[] fs = f1.listFiles();
        System.out.println(Arrays.toString(fs));

        // 以字符串形式返回获取所在文件夹
        System.out.println("f2所在文件夹为:"+f2.getParent());

        // 创建文件夹,如果父类不存在,则创建无效
        f2.mkdir();
        // 创建文件夹,如果父文件夹不存在,就会创建父文件夹
        f2.mkdirs();

        // 创建一个空文件,如果父文件夹不存在,就会抛出异常
        f2.getParentFile().mkdirs();
        f2.createNewFile();

        // 列出所有盘符
        System.out.println(Arrays.toString(f2.listRoots()));

        // 删除文件
        f3.delete();

        // JVM结束后,删除文件,常用于临时文件的删除
        f3.deleteOnExit();





    }
}
