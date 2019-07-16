package com.test.rambda;
/**
 * @author Batman create on 2019-07-15 16:59
 * Java8 lambda表达式的应用
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (int a, int b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;


        System.out.println("10 + 5 = " + lambdaTest.operate(10, 5, addition));

        System.out.println("10 - 5 = " + lambdaTest.operate(10, 5, subtraction));

        System.out.println("10 * 5 = " + lambdaTest.operate(10, 5, multiplication));

        System.out.println("10 / 5 = " + lambdaTest.operate(10, 5, division));

        // 不用括号
        GreetingService greetingService1 = message ->
                System.out.println("Hello" + message);

        // 用括号
        GreetingService greetingService2 = (message) ->
                System.out.println("Hello" + message);


        greetingService1.sayMessage("Google");
        greetingService2.sayMessage("FaceBook");

    }


    interface MathOperation {
        /**
         * 对数字a,b 进行数学运算的接口方法(接口中只有一个方法可以使用rambda表达式处理)
         * @param a number
         * @param b number
         * @return 返回运算后的结果
         */
        int operation(int a, int b);

    }

    public int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    interface GreetingService {
        /**
         * 问候类的sayMessage方法(接口中只有一个方法可以使用rambda表达式)
         * @param message 说的内容
         */
        void sayMessage(String message);
    }


}
