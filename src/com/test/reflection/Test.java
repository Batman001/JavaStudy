package com.test.reflection;

import java.lang.reflect.Method;

/**
 * @author Batman create on 2019-04-08 10:38
 */
public class Test {
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
