package com.company.caini.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created on 2018/8/3.
 * @author Batman
 */
public class DupStringTestOfHashSet {
    public static void main(String[] args) {
        // 随机生成长度为100的字符串数组
        String[] ss = new String[100];
        for(int i=0;i<ss.length;i++){
            ss[i] = randomString(2);
        }
//        System.out.println(Arrays.toString(ss));

        HashSet<String> hs = new HashSet<>();
        // 保留重复的字符串 用ArrayList容器保存
        List<String> dupStr = new ArrayList<>();
        for(String s : ss){
            if(hs.add(s)){
                continue;
            }
            else
                dupStr.add(s);
        }

        System.out.printf("总共有%d种重复的字符串%n", ss.length - hs.size());
        System.out.println("分别是" + dupStr.toString());
    }

    private static String randomString(int len) {
        String pool = "";
        for(short i = '0';i<='9';i++){
            pool += (char) i;
        }
        for(short i='a';i<='z';i++){
            pool += (char)i;
        }
        for(short i='A';i<='Z';i++){
            pool += (char)i;
        }

        Random random = new Random();
        char[] rs = new char[len];
        for(int i=0;i<len;i++){
            int index = random.nextInt(pool.length());
            rs[i] = pool.charAt(index);
        }
        // 这就是使用String的Char数组构造方法与Arrays.toString()不同的输出形式
//        System.out.println(Arrays.toString(rs));
//        System.out.println(new String(rs));
        return new String(rs);
    }

}
