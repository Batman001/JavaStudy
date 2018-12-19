package com.company.caini.collection;

import java.util.*;

/**
 * Created by sunchao on 2018/8/3.
 */
public class TestCollectionFunctions {
    public static void main(String[] args) {
        // 初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for(int i=0; i<=10; i++){
            numbers.add(i);
        }

        System.out.println("集合中数据是: " + numbers);

        Collections.reverse(numbers);
        System.out.println("集合反转后的数据为: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("集合混淆后的数据为: " + numbers);

        Collections.sort(numbers);
        System.out.println("集合排序后的数据为: " + numbers);

        Collections.swap(numbers, 0, 9);
        System.out.println("交换下标 0 和 9 后的数据为:" + numbers);

        Collections.sort(numbers); // 复原numbers中大小关系
        Collections.rotate(numbers, 2);
        System.out.println("集合向右滚动两个单位后,集合中数据为" + numbers);

        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers);
        System.out.println(synchronizedNumbers);
        System.out.println(Arrays.asList(Arrays.copyOfRange(numbers.toArray(), 0, 3)));


        System.out.printf("匹配前三位出现3,1,4的概率为%.6f",probabilitytatisticsS(numbers));


    }

    public static double probabilitytatisticsS(List<Integer> numbers) {

        // 判断出现情形,shuffle后前面出现为 3 1 4 的概率情形
        List<Integer> target = new ArrayList<>();
        target.add(3);
        target.add(1);
        target.add(4);
        int matchTargetCount = 0;

        for (int i = 0; i < 1000000; i++) {
            Collections.shuffle(numbers);
//            System.out.println(Arrays.asList(Arrays.copyOfRange(numbers.toArray(), 0, 3)));
            // 对ArraysList进行切片操作(调用Arrays的静态方法,然后再进行转换)
            if (Arrays.asList(Arrays.copyOfRange(numbers.toArray(), 0, 3)).equals(target)) {
                matchTargetCount += 1;
            } else
                continue;
        }
        System.out.println("一共匹配次数为:"+matchTargetCount);
        return (double)matchTargetCount / 1000000;
    }
}
