package com.company.caini.digitstring;

/**
 * Created by Batman on 2018/7/5.
 */
public class TestString2 {

    // 打印字符串数组的方法
    public static void printStringArrays(String[] strings){
        int count = 0;
        // 每一行放置20个字符串
        for (int i=0; i<strings.length; i++){
            count += 1;
            System.out.printf(strings[i] + "\t");
            if (count%20 == 0 )
                System.out.printf("\n");
        }
    }
    // 统计字符串数组中重复的字符串共有多少种
    public static void duplicate(String[] strings){
        int count=0;
        String str = "";
        for(int i=0;i<strings.length;i++){
            for (int j=i+1;j<strings.length;j++){
                if(strings[i].equals(strings[j])){
//                  str存在目的是用来统计重复字符串是什么?
                    if (str.contains(strings[i]))
                        break;
                    count ++;
                    str += (strings[i] + " ");
                }
            }
        }
        System.out.println("总共有" + count + "种重复的字符串");
        System.out.println("分别是:");
        System.out.println(str);
    }

    public static void main(String[] args){
        String str1 = "the light";
        String str2 = new String("the light");
        String str3 = "the light";
        String str4 = str1.toUpperCase();
        // == 适用于判断是否为同一个字符串对象
        System.out.println(str1 == str2);  // 字符串内容一样,但不是同一个字符串对象  //false
        System.out.println(str1 == str3);  // 特例 字符串内容一样,且是同一个对象   // true

        System.out.println(str1.equals(str2));  // 只匹配内容,完全一样返回true   // true
        System.out.println(str1.equals(str3));  // true
        System.out.println(str1.equals(str4));  // false
        System.out.println(str1.equalsIgnoreCase(str4)); // 忽略大小写的比较,返回true

        String start = "the";
        String end = "light";
        System.out.println(str1.startsWith(start)); // 字符串是以其子字符串开始
        System.out.println(str1.endsWith(end));   // 字符串是以其子字符串结束
        System.out.println(str1.startsWith("th"));

        // 创建一个长度是100的字符串数组
        // 使用长度是2的随机字符填充该字符串数组
        // 统计这个字符串数组里 重复的字符串有多少种

        // 打印输出100个子字符串
        String[] ss = new String[200];
        for(int i=0;i<ss.length;i++){
            ss[i] = TestChar.randomString(2);
        }
        printStringArrays(ss);
        duplicate(ss);


    }
}
