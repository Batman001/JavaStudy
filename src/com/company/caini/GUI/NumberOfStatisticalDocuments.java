package com.company.caini.GUI;

import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by sunchao on 2018/11/14.
 * 统计文件数量
 * 借助时间控件，选中一个时间，然后根据这个时间，统计/Users/sunchao/JavaProjects/JavaStudy
 * 修改时间大于这个时间的文件，一共有多少
 */
public class NumberOfStatisticalDocuments {
    public static void main(String[] args) {
        JFrame f = new JFrame("统计文件数量");
        f.setSize(500, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        final DatePicker datePicker;
        datePicker = getDatePicker();
        f.add(datePicker);

        JPanel p = new JPanel();
        JLabel lPath = new JLabel("统计文件路径为:");

        JTextField tf = new JTextField("");
//        tf.setText("/Users/sunchao/JavaProjects/JavaStudy");
        tf.setPreferredSize(new Dimension(150, 30));

        JLabel lTime = new JLabel("统计文件时间为");
        JTextField tfTime = new JTextField("");
        tfTime.setPreferredSize(new Dimension(150, 30));


        JButton b = new JButton("统计");
        b.setBounds(20, 183, 450, 30);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = tf.getText();

                File folder = new File(filePath);
                Date d = (Date) datePicker.getValue();
                tfTime.setText(d.toString());
                JOptionPane.showMessageDialog(f, "文件总数是" +
                        countFilesModifiedDateGreaterThan(folder, d));


            }
        });
        p.add(lPath);
        p.add(tf);
        p.add(lTime);
        p.add(tfTime);
        p.add(b);
        f.add(p, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };

        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        // datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }

    /**
     * 递归实现遍历文件夹得到全部文件
     * @param folder 目标文件夹
     * @return
     */
    public static List<File> scanFolder(File folder){
        List<File> files = new ArrayList<>();
        File[] fs = folder.listFiles();
        for (File f : fs) {
            if(f.isDirectory()){
                List<File> subFolderFiles = scanFolder(f);
                files.addAll(subFolderFiles);
            }
            if(f.isFile()){
                files.add(f);
            }
        }
        return files;
    }

    public static long countFilesModifiedDateGreaterThan(File folder, Date d){
        List<File> fs = scanFolder(folder);
        return fs.stream().filter(f->f.lastModified()>d.getTime()).count();

    }



}
