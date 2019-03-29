package com.company.caini.collection;

import java.util.*;

/**
 * @author sunchao
 * @create 2019-01-16 9:11 AM
 */
public class NumOfElement {
    public static void main(String[] args) {
        String[] arr = new String[]{"aaa", "bbb", "ccc", "aaa", "ddd", "ccc", "bbb", "ee", "cccc"};

        Map<String,Integer> map = new HashMap<>();

        for(String str : arr){
            Integer num = map.get(str);
            map.put(str, num == null ? 1 : num + 1);
        }
        Set set = map.entrySet();
        Iterator it = set.iterator();
        System.out.println("方法一:");

        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it .next();
            System.out.println("单词" + entry.getKey() + "出现次数: " + entry.getValue());

        }

        System.out.println("方法二:");
        Iterator it2 = map.keySet().iterator();
        while(it2.hasNext()){
            Object key = it2.next();
            System.out.println("单词" + key + "出现次数: " + map.get(key));
        }

        Map<String, Integer> sortMap = sortMapByValue(map);
        printMap(sortMap);

    }

    private static void printMap(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Key :" + entry.getKey() +
                    "value : " + entry.getValue() );
        }
    }

    private static Map<String,Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> mapList
                = new ArrayList<>();
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Map<String, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry:mapList){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
