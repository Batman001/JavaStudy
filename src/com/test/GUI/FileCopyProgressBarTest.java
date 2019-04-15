package com.test.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用面板swing实现文件夹的复制功能
 */
public class FileCopyProgressBarTest{
    /**
     * 所有需要复制的文件的总大小
     * @param allFileSize
     */
    static long allFileSize = 0;
    /**
     * 当前已经复制完成的文件大小
     * @param args
     */
    static long currentFileCopiedSize = 0;
    
    /**
     * 计算全部文件的大小 递归实现
     * @param file
     */
    public static void calAllFileSize(File file){
        if(file.isFile()){
            allFileSize += file.length();
        }
        if(file.isDirectory()){
             File[] fs = file.listFiles();
             for(File f:fs){
                 calAllFileSize(f);
             }
        }
    }
    public static void main(String[] args){
        // 设置显示界面
        JFrame f = new JFrame("FileCopy");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        // 文件源地址
        JLabel lSrc = new JLabel("原文件地址:");
        JTextField tfSrc = new JTextField("");
        tfSrc.setText("/Users/Batman/JavaProjects/JavaStudy/");
        tfSrc.setPreferredSize(new Dimension(100, 30));
        JLabel lDest = new JLabel("复制到:");
        JTextField tfDest = new JTextField("");
        tfDest.setText("/Users/Batman/Desktop/JavaTest");
        tfDest.setPreferredSize(new Dimension(100, 30));

        f.add(lSrc);
        f.add(tfSrc);
        f.add(lDest);

        f.add(tfDest);
        

        JButton bStartCopy = new JButton("点击复制");
        bStartCopy.setPreferredSize(new Dimension(100, 30));
        JLabel l = new JLabel("复制进度");
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);
        f.add(bStartCopy);
        f.add(pb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


        // 计算需要复制的文件大小
        String srcPath = tfSrc.getText();
        File folder = new File(srcPath);
        calAllFileSize(folder);

        // 点击开始复制
        bStartCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFileCopiedSize = 0;
                String srcPath = tfSrc.getText();
                String destPath = tfDest.getText();
                new Thread(){
                    @Override
                    public void run(){
                        copyFolder(srcPath, destPath);
                    }
                }.start();
                bStartCopy.setEnabled(false);
            }

            /**
             * 复制文件
             * @param srcPath 待复制的文件路径
             * @param destPath  复制后的文件路径
             */
            public void copyFile(String srcPath, String destPath){
                File srcFile = new File(srcPath);
                File destFile = new File(destPath);

                // 设置缓存区的大小
                byte[] buffer = new byte[1024];
                try(
                        FileInputStream fis = new FileInputStream(srcFile);
                        FileOutputStream fos = new FileOutputStream(destFile);
                        ){
                    while(true){
                        int acturallyReaded = fis.read(buffer);
                        if(-1==acturallyReaded){
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
             * 复制文件夹
             * @param srcFolderPath 待复制的文件夹路径
             * @param destFolderPath 复制后的文件夹路径
             */
            public void copyFolder(String srcFolderPath, String destFolderPath){
                File srcFolder = new File(srcFolderPath);
                File destFolder = new File(destFolderPath);
                //判断条件
                if(!srcFolder.exists()){
                    return;
                }
                if(!srcFolder.isDirectory()){
                    return;
                }
                if(destFolder.isFile()){
                    return ;
                }
                if(!destFolder.exists()){
                    destFolder.mkdirs();
                }

                File[] srcFiles = srcFolder.listFiles();
                for(File srcFile : srcFiles){
                    if(!srcFile.isDirectory()){
                        File newDestFile = new File(destFolder, srcFile.getName());
                        // 进行文件的复制
                        copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
                        // 更新进度条
                        currentFileCopiedSize+=srcFile.length();
                        double currentValue = (double)currentFileCopiedSize/(double)allFileSize;
                        int currentProgress = (int) currentValue * 100;
                        pb.setValue(currentProgress);

                        // 判断进度条结束的条件
                        if (currentProgress == 100){
                            JOptionPane.showMessageDialog(f,"复制完成!");
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