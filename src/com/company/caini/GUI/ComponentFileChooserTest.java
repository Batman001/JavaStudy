package com.company.caini.GUI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by sunchao on 2018/11/5.
 */
public class ComponentFileChooserTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setLayout(new FlowLayout());
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith("text");
            }
            @Override
            public String getDescription() {
                return ".text";
            }
        });

        JButton bOpen = new JButton("打开文件");
        bOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(f, "打开文件位置为:"+file.getAbsolutePath());
                }

            }
        });

        JButton bSave = new JButton("保存文件");
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(f, "保存文件位置为:" + file.getAbsolutePath());
                }

            }
        });
        f.add(bOpen);f.add(bSave);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
