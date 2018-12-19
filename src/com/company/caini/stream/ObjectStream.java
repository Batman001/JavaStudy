package com.company.caini.stream;

import com.company.caini.character.Hero;

import java.io.*;

/**
 * Created by sunchao on 2018/7/30.
 */
public class ObjectStream {
    public static void main(String[] args){
        // 创建一个Hero garen
        Hero garen = new Hero("garen", 189.f);
        // 准备一个文件用于保存对象
        File f = new File("/Users/sunchao/JavaProjects/JavaStudy/data/garen.lol");
        try(
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            oos.writeObject(garen);
            Hero h = (Hero) ois.readObject();
            System.out.println(h.name);
            System.out.println(h.hp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
