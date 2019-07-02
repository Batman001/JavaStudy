package com.test.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Batman on 2018/11/13.
 * 显示文件夹复制进度条
 */
public class FileCopyProgressBar {

    /**
     * 所有需要复制的文件的大小 allFileSize
     */
    static long allFileSize = 0;

    /**
     * 已经复制的文件的大小
     */
    static long currentFileSizeCopied = 0;

    public static void calAllFilesSize(File file){
        if(file.isFile()){
            allFileSize += file.length();
        }
        // 递归实现遍历一个文件夹并将大小添加进allFileSize里
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            for(File f:fs){
                calAllFilesSize(f);
            }
        }

    }

    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(450, 140);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());


        // 文件地址
        JLabel lSrc = new JLabel("源文件地址:");
        JTextField srcTf = new JTextField("");
        srcTf.setText("/Users/Batman/JavaProjects/JavaStudy/");
        srcTf.setPreferredSize(new Dimension(100, 30));
        JLabel lDest = new JLabel("复制到:");
        JTextField destTf = new JTextField("");
        destTf.setText("/Users/Batman/Desktop/java/");
        destTf.setPreferredSize(new Dimension(100, 30));

        f.add(lSrc);
        f.add(srcTf);
        f.add(lDest);
        f.add(destTf);


        JButton bStartCopy = new JButton("开始复制");
        bStartCopy.setPreferredSize(new Dimension(100, 30));

        JLabel l = new JLabel("文件夹复制进度");
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);

        f.add(bStartCopy);
        f.add(l);
        f.add(pb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // 计算需要复制的文件的总大小
        String srcPath = srcTf.getText();
        File folder = new File(srcPath);
        calAllFilesSize(folder);

        // 点击开始复制
        bStartCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFileSizeCopied  = 0;

                String srcPath = srcTf.getText();
                String destPath = destTf.getText();
                new Thread(){
                    @Override
                    public void run(){
                        copyFolder(srcPath, destPath);
                    }
                }.start();
                bStartCopy.setEnabled(false);
            }

            /**
             * 文件复制函数 copyFile
             */
            public void copyFile(String srcPath, String destPath){
                File srcFile = new File(srcPath);
                File destFile = new File(destPath);

                // 缓存区,一次读取1024字节
                byte[] buffer = new byte[1024];
                try(
                        FileInputStream fis = new FileInputStream(srcFile);
                        FileOutputStream fos = new FileOutputStream(destFile)

                ){
                    while(true){
                        int acturallyReaded = fis.read(buffer);
                        if(-1 == acturallyReaded){
                            break;
                        }
                        fos.write(buffer, 0, acturallyReaded);
                        fos.flush();
                    }

                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            /**
             * 递归实现复制文件夹函数
             */
            public void copyFolder(String srcPath, String destPath){
                File srcFolder = new File(srcPath);
                File destFolder = new File(destPath);

                if(!srcFolder.exists()){
                    return;
                }

                if(!srcFolder.isDirectory()){
                    return;
                }

                if(destFolder.isFile()){
                    return;
                }

                if(!destFolder.exists()){
                    destFolder.mkdirs();
                }
                File[] files = srcFolder.listFiles();
                for(File srcFile:files){
                    if(!srcFile.isDirectory()){
                        File newDestFile = new File(destFolder, srcFile.getName());
                        copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
                        currentFileSizeCopied += srcFile.length();

                        double current = (double)currentFileSizeCopied / (double)allFileSize;
                        int progress = (int) current * 100;
                        pb.setValue(progress);
                        if(progress == 100){
                            JOptionPane.showMessageDialog(f, "复制完成");
                            bStartCopy.setEnabled(true);
                        }
                    }
                    if(srcFile.isDirectory()){
                        File newDestFolder = new File(destFolder, srcFile.getName());
                        copyFolder(srcFile.getAbsolutePath(), newDestFolder.getAbsolutePath());
                    }

                }

            }
        });


    }


}
