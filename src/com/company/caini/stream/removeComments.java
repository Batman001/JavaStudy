package com.company.caini.stream;

import java.io.*;

/**
 * Created by Batman on 2018/7/30.
 */
public class removeComments {
    public static void main(String[] args){
        File f = new File("/Users/Batman/JavaProjects/JavaStudy/data/Hero.java");
        File afterf = new File("/Users/Batman/JavaProjects/JavaStudy/data/AfterProcessedHero.java");
        String startStr = "//";
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(afterf);
                PrintWriter pw = new PrintWriter(fw);
                ){
            while(true){
                String line = br.readLine();
                if(line == null)
                    break;
                else if (line.trim().startsWith(startStr)){
                    continue;
                }
                pw.println(line);
                System.out.println(line);

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
