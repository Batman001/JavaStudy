package com.test.genericall;

import java.util.Random;

/**
 * @author Batman create on 2019-05-21 15:26
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
 */
public class FruitGenerator implements Generator{


    private String[] fruits = {"apple", "pineapple", "banana", "pear"};
    /**
     * next方法 返回一个对象
     * 在实现类实现泛型接口时，
     * 如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
     * @return 对应的T对象
     */
    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(4)];
    }




    public static void main(String[] args) {
        FruitGenerator fruitGenerator = new FruitGenerator();
        System.out.println(fruitGenerator.next());
    }
}
