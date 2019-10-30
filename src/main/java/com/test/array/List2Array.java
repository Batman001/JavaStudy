package com.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-09-24 17:39
 */
public class List2Array {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
//        test.add(Integer.parseInt("11"));
//        test.add(Integer.parseInt("10"));

        int[] a = test.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(a);
        System.out.println(test.isEmpty());


        String str = "1";
        Integer b;
        b = Integer.parseInt(str);
        System.out.println(b);
    }
}
