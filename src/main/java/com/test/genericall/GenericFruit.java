package com.test.genericall;

/**
 * @author Batman create on 2019-05-21 16:33
 */
public class GenericFruit {

    class Fruit{
        @Override
        public String toString(){
            return "Fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString(){
            return "Person";
        }
    }

    class GenericTest<T>{

        private void showOne(T t){
            System.out.println(t.toString());
        }


        /**
         * 在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，
         * 可以与泛型类中声明的T不是同一种类型。
         * @param t 泛型类型
         * @param <T> 表征泛型方法
         */
        private <T> void showTwo(T t){
            System.out.println(t.toString());
        }

        /**
         * 在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
         * 由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，
         * 编译器也能够正确识别泛型方法中识别的泛型。
         * @param t 泛型类型
         * @param <E> 表征泛型方法
         */
        private <E> void showThree(E t){
            System.out.println(t.toString());
        }


    }

    public static void main(String[] args) {
        GenericFruit gf = new GenericFruit();
        Apple apple = gf.new Apple();
        Person person = gf.new Person();


        GenericTest<Fruit> genericTest = gf.new GenericTest<>();
        genericTest.showOne(apple);
        // 因为泛型类型实参指定的是Fruit，而传入的实参类是Person
//        genericTest.showOne(person); 不兼容的类型:Person无法转换为Fruit
        genericTest.showTwo(apple);
        genericTest.showTwo(person);

        genericTest.showThree(apple);
        genericTest.showThree(person);


    }

}
