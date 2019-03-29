package com.company.caini.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Batman on 2018/11/12.
 */
public class JavaFilePane extends JPanel {

    public JavaFilePane(File file){
        this.setLayout(new BorderLayout());
        String fileContent = getFileContent(file);
        JTextArea ta = new JTextArea();
        ta.setText(fileContent);
        this.add(ta);
    }

    private String getFileContent(File file) {
        String fileContent = "";
        try(FileReader fr = new FileReader(file)
        ){
            char[] all = new char[(int) file.length()];
            fr.read(all);
            fileContent = new String(all);

        }catch(IOException e){
            e.printStackTrace();
        }
        return fileContent;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Eclipse");
        f.setSize(400, 300);
        f.setContentPane(new JavaFilePane(new File(
                "/Users/Batman/JavaProjects/JavaStudy/src/com/company/caini/GUI/JavaFilePane.java")));
        f.setVisible(true);

    }

}
