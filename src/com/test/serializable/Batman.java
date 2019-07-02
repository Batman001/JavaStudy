package com.test.serializable;

import java.io.Serializable;

/**
 * @author Batman create on 2019-07-02 09:35
 * 测试Obeject类的序列化与反序列化
 */
public class Batman implements Serializable {

    private static final long serialVersionUID=1L;

    public static String pre = "Silence";
    transient String bro = "Robin";

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Batman{" + "name=" + name + ",age=" + age + ",pre=" + pre + ",bro=" + bro + "}";
    }

}
