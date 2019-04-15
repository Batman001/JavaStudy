package com.test.reflection;

import java.lang.reflect.Method;

/**
 * @author Batman create on 2019-04-08 10:36
 */
public class Student {
    private static Student student = new Student();
    private String name;
    private int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

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

    public void getNameAndScore(String name, double score){
        System.out.println("学生姓名：" + name + "\t 成绩为：" + score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String[] args)throws Exception {
        Student student = new Student();
        student.setName("Batman");
        student.setAge(19);

        /** 1. 无参数 **/
        Method method = student.getClass().getMethod("getName");
        String name = (String) method.invoke(student);
        System.out.println("通过反射调用getName方法得到student的名字为："+name);

        /** 2. 一个参数 **/
        Method method1 = student.getClass().getMethod("setName", String.class);
        method1.invoke(student, "Robin");

        /** 3.多个参数 */
        Method method2 = student.getClass().getMethod("method", int.class, String.class);
        method2.invoke(student, 88, "Joker");

        System.out.println(student);


        /** 4.调用double类型的参数 **/
        Method method3 = student.getClass().getMethod("getNameAndScore", String.class, double.class);
        method3.invoke(student,"Batman", 100.56);


    }
}
