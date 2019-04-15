package com.test.digitstring;

/**
 * Created by Batman on 2018/7/5.
 */
public class ControlString {

    public static String sentenceFirstCharIntoUpper(String sen){
        String[] words = sen.split(" ");
        String result = "";
        for(String word : words){
            char[] ws = word.toCharArray();
            ws[0] = Character.toUpperCase(ws[0]);
            result += String.valueOf(ws)+ " ";
        }
        return result.trim();

    }
    public static void main(String[] args){
        String sentence = "   盖伦,在进行了连续8次击杀后,获得了超神的称号   ";
        char[] cs = sentence.toCharArray();
        System.out.println(sentence.length() == cs.length);

        // 截取从第3个开始的字符串(基0)

        String substr1 = sentence.substring(3);
        System.out.println(substr1);

        // 截取从第3个到第5个字符的字符串,但不包含第5个,即左闭右开

        String substr2 = sentence.substring(3,5);
        System.out.println(substr2);

        // 根据某个字符对字符串进行切割 得到子串
        String[] sentences = sentence.split(",");
        for(String sub:sentences){
            System.out.println(sub);
        }

        // 去掉首尾空格
        System.out.println(sentence.trim());

        // 字符串的大小写转换
        String heroName = "Garen";
        System.out.println(heroName.toUpperCase());
        System.out.println(heroName.toLowerCase());

        // 字符串子元素的定位
        // indexOf 判断字符或者子字符串出现的位置
        // contains 是否包含子字符串
        System.out.println(sentence.trim().indexOf('8'));
        System.out.println(sentence.trim().indexOf("超神"));  // 字符串第一次出现的位置
        System.out.println(sentence.trim().lastIndexOf("了")); // 字符串最后出现的位置
        System.out.println(sentence.trim().indexOf(",",5)); // 从位置5开始,第一次出现","的位置
        System.out.println(sentence.contains("击杀"));

        // 替换操作
        // replaceAll 替换所有的
        // replaceFirst 只替换第一个
        String temp = sentence.replaceAll("击杀","被击杀");
        temp = temp.replaceAll("超神","超鬼");
        System.out.println(temp.trim());

        System.out.println(sentence.trim().replaceFirst(",",""));

        // 每个单词的首字母都转换成大写
        System.out.println(sentenceFirstCharIntoUpper("let there be light, i love you"));

    }
}
