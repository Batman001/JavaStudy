package com.test.serializable;

import java.io.*;

/**
 * @author Batman create on 2019-07-02 09:36
 * Serializable测试对象序列化与反序列化的测试类
 */
public class SerTest {
    public static void main(String[] args) {
        Batman batman = new Batman();

        batman.setName("Bruce Wayne");
        batman.setAge(35);

        System.out.print("序列化前的对象打印结果为：" + batman + "\n");

        // 将对象写到文件中
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BatSer"));){
            oos.writeObject(batman);
        }catch (IOException e){
            e.printStackTrace();
        }

        // 这里修改Batman类中静态变量
        Batman.pre="No Silence";

        // 从文件中读取对象
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Batser")));) {
            Batman bat = (Batman)ois.readObject();
            System.out.print("序列化后的对象打印结果为：" + bat + "\n");
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    /*
     * 此时输出结果为:
     * 序列化前的对象打印结果为：Batman{name=Bruce Wayne,age=35,pre=Silence,bro=Robin}
     * 序列化后的对象打印结果为：Batman{name=Bruce Wayne,age=35,pre=No Silence,bro=null}
     * reason1:序列化保存的是对象的状态，而 static 修饰的字段属于类的状态，因此可以证明序列化并不保存 static 修饰的字段。
     * reason2:transient 的中文字义为“临时的”（论英语的重要性），它可以阻止字段被序列化到文件中，
     * 在被反序列化后，transient 字段的值被设为初始值，比如 int 型的初始值为 0，对象型的初始值为 null。
     */
}
