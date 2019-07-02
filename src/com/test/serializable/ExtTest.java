package com.test.serializable;

import java.io.*;

/**
 * @author Batman create on 2019-07-02 10:11
 */
public class ExtTest {
    public static void main(String[] args) {

        Joker joker = new Joker();
        joker.setName("Health Ledger");
        joker.setAge(30);

        System.out.println(joker);

        // 将对象写到文件中
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jokerExter"));){
            oos.writeObject(joker);
        }catch(IOException e){
            e.printStackTrace();
        }

        // 从文件中读取对象
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("jokerExter")));){
            Joker readJoker = (Joker)ois.readObject();
            System.out.println(readJoker);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
