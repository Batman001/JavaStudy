package com.test.reflection;

/**
 * @author Batman create on 2019-04-08 10:36
 */
public class Student {
    private static Student student = new Student();
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void method(int param1, String param2){
        System.out.println(param1 + param2);

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
