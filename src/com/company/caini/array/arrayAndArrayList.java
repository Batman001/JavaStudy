package com.company.caini.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018/11/30.
 * @author Batman
 */
public class ArrayAndArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("BOB");
        list.add("TOM");
        list.add("Jerry");
        int size = list.size();
        String[] array = list.toArray(new String[size]);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

        System.out.println();

        String[] strArray = new String[3];
        strArray[0] = "Tony";
        strArray[1] = "grace";
        strArray[2] = "fuck";
        List<String> arrList = Arrays.asList(strArray);
        for(int i=0;i<arrList.size();i++){
            System.out.println(arrList.get(i));
        }

        Integer[] intArray = {1,2,3,4};
        List<Integer> intList = Arrays.asList(intArray);
        for(int i=0;i<intList.size();i++){
            System.out.println(intList.get(i));
        }


    }
}
