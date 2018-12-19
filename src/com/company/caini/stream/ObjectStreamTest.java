package com.company.caini.stream;

import com.company.caini.character.Hero;

import java.io.*;

/**
 * Created by sunchao on 2018/7/30.
 */
public class ObjectStreamTest {
    public static void main(String[] args){
        File f = new File("/Users/sunchao/JavaProjects/JavaStudy/data/HeroSerial.lol");
        try(
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)
                ){
            Hero[] heros = new Hero[10];
            for(int i=0;i<heros.length;i++){
                heros[i] = new Hero();
                heros[i].name = "hero" + String.valueOf(i+1);
            }
            for(int i=0;i<heros.length;i++){
                oos.writeObject(heros[i]);
            }

            for(int i=0;i<heros.length;i++){
                System.out.println(ois.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
