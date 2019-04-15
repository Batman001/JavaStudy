package com.test.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java反射机制demo测试
 * @author Batman
 */
public class ReflectionDemo {
    /**
     * 为了看清楚Java反射部分代码，所有异常我都最后抛出来给虚拟机处理！
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException, NoSuchMethodException {
        // demo1. 通过Java反射机制得到类的包名和类名
        demo1();
        System.out.println("===============================================");

        // demo2. 验证所有的类都是Class类的实例对象
        demo2();
        System.out.println("===============================================");

        // demo3. 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]，无参构造
        demo3();
        System.out.println("===============================================");

        // demo4: 通过Java反射机制得到一个类的构造函数，并实现构造带参实例对象
        demo4();
        System.out.println("===============================================");

        // demo5: 通过Java反射机制操作成员变量, set 和 get
        demo5();
        System.out.println("===============================================");

        // demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
        demo6();
        System.out.println("===============================================");

        // demo7: 通过Java反射机制调用类中方法
        demo7();
        System.out.println("===============================================");

        // demo8: 通过Java反射机制获得类加载器
        demo8();
        System.out.println("===============================================");

    }

    /**
     * demo1: 通过Java反射机制得到类的包名和类名
     */
    private static void demo1() {
        Person person = new Person();
        System.out.println("demo1: 包名: " + person.getClass().getPackage().getName() + "，" + "完整类名: " + person.getClass().getName());

    }

    /**
     * demo2: 验证所有的类都是Class类的实例对象
     *
     * @throws ClassNotFoundException
     */
    private static void demo2() throws ClassNotFoundException {
        // 定义两个类型都未知的Class , 设置初值为null, 看看如何给它们赋值成Person类
        Class<?> class1 = null;
        Class<?> class2 = null;

        // 写法1, 可能抛出 ClassNotFoundException [多用这个写法]
        class1 = Class.forName("com.test.reflection.Person");
        System.out.println("demo2:(写法1) 包名: " + class1.getPackage().getName() + "，" + "完整类名: " + class1.getName());


        // 写法2
        class2 = Person.class;
        System.out.println("demo2:(写法2) 包名: " + class2.getPackage().getName() + "，" + "完整类名: " + class2.getName());

    }

    /**
     * demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> class1 = null;
        class1 = Class.forName("com.test.reflection.Person");
        // 由于这里不能带参数，所以你要实例化的这个类Person，一定要有无参构造函数
        Person person = (Person) class1.newInstance();
        person.setAge(20);
        person.setName("Robin");
        System.out.println("demo3:" + person);

    }

    /**
     * demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
     *
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IllegalArgumentException
     */
    private static void demo4() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;

        class1 = Class.forName("com.test.reflection.Person");
        // 得到一系列构造函数集合
        Constructor<?>[] constructors = class1.getConstructors();

        person1 = (Person) constructors[0].newInstance();
        person1.setAge(30);
        person1.setName("Robin");

        person2 = (Person) constructors[1].newInstance(20, "Batman");

        System.out.println("demo4:" + person1 + "\n" + person2);

    }

    /**
     * demo5: 通过Java反射机制操作成员变量, set 和 get
     *
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    private static void demo5() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, InstantiationException, ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.test.reflection.Person");
        Object obj = class1.newInstance();

        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true);
        personNameField.set(obj, "SpiderMan");

        System.out.println("demo5: 修改属性之后得到属性变量的值：" + personNameField.get(obj));

    }

    /**
     * demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
     *
     * @throws ClassNotFoundException
     */
    private static void demo6() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.test.reflection.SuperMan");

        // 取得父类名称
        Class<?> superClass = class1.getSuperclass();
        System.out.println("demo6:  SuperMan类的父类名: " + superClass.getName());


        System.out.println("===============================================");

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("类中的成员: " + fields[i]);
        }

        System.out.println("===============================================");

        // 取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("demo6,取得SuperMan类的方法：");
            System.out.println("函数名：" + methods[i].getName());
            System.out.println("函数返回类型：" + methods[i].getReturnType());
            System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
            System.out.println("函数代码写法： " + methods[i]);
        }


        System.out.println("===============================================");

        // 取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈
        Class<?>[] interfaces = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("实现的接口类名: " + interfaces[i].getName());
        }


    }

    /**
     * demo7: 通过Java反射机制调用类方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     */
    private static void demo7() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> class1 = null;
        class1 = Class.forName("com.test.reflection.SuperMan");

        System.out.println("demo7: \n调用无参方法fly()");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("调用有参方法walk(int m)");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);


    }

    /**
     * demo8: 通过Java反射机制得到类加载器信息
     *
     * 在java中有三种类类加载器。
     *
     * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     *
     * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
     *
     * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
     *
     * @throws ClassNotFoundException
     */
    private static void demo8() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.test.reflection.SuperMan");
        String nameString = class1.getClassLoader().getClass().getName();

        System.out.println("demo8: 类加载器类名: " + nameString);

        /**
         运行结果：
         demo8: 类加载器类名: sun.misc.Launcher$AppClassLoader
         */
    }

}


class Person {
    private int age;
    private String name;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class SuperMan extends Person implements ActionInterface {
    /** 是否为蓝色内裤 */
    private boolean blueBriefs;

    public void fly() {
        System.out.println("fly method....");
    }

    public boolean isBlueBriefs() {
        return blueBriefs;
    }

    public void setBlueBriefs(boolean isBlueBriefs) {
        blueBriefs = isBlueBriefs;
    }

    @Override
    public void walk(int m) {
        System.out.println("fly in " + m + " minutes");
    }
}

interface ActionInterface {
    public void walk(int m);
}