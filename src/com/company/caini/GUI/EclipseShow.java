package com.company.caini.GUI;

import javax.swing.*;
import java.io.File;

/**
 * Created by Batman on 2018/11/12.
 */
public class EclipseShow {
    public static void main(String[] args) {
        JFrame f = new JFrame("Eclipse");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        File folder = new File("/Users/Batman/JavaProjects/JavaStudy/src/com/company/caini/GUI/");
        File[] fs = folder.listFiles();
        JTabbedPane tp = new JTabbedPane();
        ImageIcon icon = new ImageIcon("/Users/Batman/Desktop/test.jpg");
        for(int i=0;i<fs.length;i++){
            JavaFilePane jfp = new JavaFilePane(fs[i]);
            tp.add(jfp);
            tp.setIconAt(i, icon);
            tp.setTitleAt(i, shortName(fs[i].getName()));
        }
        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static String shortName(String name) {
        int length = 6;
        if(name.length() > length){
            return name.substring(0, length) + "...";
        }
        return name;
    }


}
