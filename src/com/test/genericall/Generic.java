package com.test.genericall;

/**
 * @author Batman create on 2019-05-21 15:17
 * 泛型类
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 */
public class Generic<T> {

    /**
     * key这个成员变量的类型为T,T的类型由外部指定
     */
    private T key;

    /**
     * 泛型构造方法 形参key为T类型 T的类型由外部指定
     * @param key
     */
    public Generic(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    private static void showKeyValue(Generic<Number> obj){
        System.out.println("使用固定的实参类型获取key值为："+obj.getKey());
    }


    /**
     * 解决当具体类型不确定的时候，这个通配符就是 ?  ；
     * 当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。
     * 那么可以用 ? 通配符来表未知类型
     * @param obj
     */
    private static void showKeyValueWildCard(Generic<?> obj){
        System.out.println("使用通配符获取key值为："+obj.getKey());
    }


    private static void showKeyValueWithBorder(Generic<? extends Number> obj){
        System.out.println("泛型边界测试，此时泛型为Number 获取key值为：" + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> genericInteger = new Generic<>(123456);

        Generic<String> stringGeneric = new Generic<>("key_value");

        System.out.println("====================测试泛型类====================");
        System.out.println("泛型测试的key为：" + genericInteger.getKey());
        System.out.println("泛型测试的key为：" + stringGeneric.getKey());



        System.out.println("====================测试泛型的通配符====================");
        //Generic<Number>和Generic<Integer>具有父子关系的泛型类型
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> nInteger = new Generic<>(456);

        // showKeyValue(gInteger); 不兼容的类型 无法将Generic<Integer>转换为Generic<Number>

        showKeyValue(nInteger);


        showKeyValueWildCard(gInteger);
        showKeyValueWildCard(nInteger);


        System.out.println("====================测试泛型的上下边界====================");

        Generic<String> generic1 = new Generic<>("11111");
        Generic<Integer> generic2 = new Generic<>(2222);
        Generic<Float> generic3 = new Generic<>(2.4f);
        Generic<Double> generic4 = new Generic<>(2.56);
//        showKeyValueWithBorder(generic1);  这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        showKeyValueWithBorder(generic2);
        showKeyValueWithBorder(generic3);
        showKeyValueWithBorder(generic4);





    }
}
