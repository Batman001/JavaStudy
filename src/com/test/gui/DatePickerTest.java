package com.test.gui;


import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Batman on 2018/11/14.
 * 本例使用 datepicker.jar 包，有一个缺点，不能设置时间，只能在创建控件的时候传入指定日期。
 * 需要设置日期，请使用JXDatePicker
 */
public class DatePickerTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);

        final DatePicker datepicker;
        datepicker = getDatePicker();
        f.add(datepicker);

        JButton b = new JButton("获取时间");
        b.setBounds(137, 183, 100, 30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "获取控件的日期是:"+datepicker.getValue());
                System.out.println(datepicker.getValue());
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static DatePicker getDatePicker() {
        final DatePicker datePicker;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };

        datePicker = new DatePicker(date, DefaultFormat, font, dimension);

        datePicker.setLocation(137, 83);
        datePicker.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datePicker.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datePicker.setDisableddays(disabledDays);
        // 设置国家
        datePicker.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datePicker.setTimePanleVisible(true);


        return datePicker;
    }
}
