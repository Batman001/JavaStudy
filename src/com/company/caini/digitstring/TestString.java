package com.company.caini.digitstring;

import com.company.caini.character.Hero;

import java.util.Locale;

/**
 * Created by sunchao on 2018/7/4.
 */
public class TestString {

    public static void main(String[] args) {
        Hero h = new Hero("盖伦", 100.23f);
        int kill = 9;
        String title = "超神";
        // 字符串拼接
        String sentence = h.name + " 在进行了连续 " + kill + " 次击杀后,获得了 " + title + " 的称号";
        System.out.println(sentence);

        // 使用格式化输出
        // %s表示字符串,%d表示数字,%n表示换行
        String sentenceFormal = "%s 在进行了连续 %d 次击杀后,获得了 %s 的称号 %n";
        System.out.printf(sentenceFormal, h.name, kill, title);

        // foramt 同样可以达到效果
        System.out.format(sentenceFormal, h.name, kill, title);


        // 测试打印输出对齐设置
        int year = 2020;

        System.out.printf("%d%n", year);

        //总长度为8,默认右对齐
        System.out.printf("%8d%n", year);
        //总长度为8,左对齐
        System.out.printf("%-8d%n", year);
        //总长度为8,不够补0
        System.out.printf("%08d%n", year);

        // 千位分隔符
        System.out.printf("%,8d%n", year * 10000);

        //小数点位数
        System.out.printf("%.2f%n", Math.PI);

        // 不同国家的千位分隔符
        System.out.printf(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
        System.out.printf(Locale.US, "%,.2f%n", Math.PI * 10000);
        System.out.printf(Locale.UK, "%,.2f%n", Math.PI * 10000);


        // 使用Scanner读取字符串数组,然后格式化输出
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("请输入地名:");
        String dm = input.next();
        System.out.println("请输入公司类型:");
        String lx = input.next();
        System.out.println("请输入公司名称:");
        String compny = input.next();
        System.out.println("输入老板名称:");
        String boss = input.next();
        System.out.println("输入金额:");
        int je = input.nextInt();
        System.out.println("输入产品:");
        String cp = input.next();
        System.out.println("请输入价格单位:");
        String dw = input.next();
        String sc = "%s最大的%s%s倒闭了,王八蛋老板%s吃喝嫖赌,%n" +
                "欠下了%d个亿,待着他的小姨子跑了,我们没有办法,拿着%s抵工资,%n" +
                "原价都是一%s多,两%s多,三%s多的代码,现在全部只卖20块,统统只要20块,%n" +
                "%s王八蛋,你不是人,我们辛辛苦苦的给你干了大半年,你不发工资,%n"+
                "你还我血汗钱,你还我血汗钱,还我血汗钱";
        System.out.printf(sc,dm,lx,compny,boss,je,cp,dw,dw,dw,boss);

*/
        String[] ss = new String[10000]; // 会引发java的垃圾回收机制,由于被重写,会打印信息:自己创建的重写object垃圾回收机制
        for (int i = 0; i < ss.length; i++) {
            ss[i] = CombineTest.randomString(2);
        }
        int count = 0;
        // 打印100个子字符串的字符串数组
        for (int i = 0; i < ss.length; i++) {
            System.out.printf(ss[i] + "\t");
            count += 1;
            if (count % 20 == 0)
                System.out.printf("%n");
        }

        // 统计100个字符串数组中重复字符串出现的数量及字符串是什么
        int countdup = 0;
        String dupStr = "";
        for (int i = 0; i < ss.length; i++) {
            for (int j = i + 1; j < ss.length; j++) {
                if (ss[i].equals(ss[j])) {
                    // 如果之前识别到重复出现的字符串,又一次碰到该字符串,直接跳过该次循环
                    if (dupStr.contains(ss[i]))
                        break;
                    // 统计从未出现的重复的字符串
                    countdup += 1;
                    // 不断更新出现的字符串 添加进dupStr中
                    dupStr += ss[i] + " ";
                }
            }

        }
        System.out.println(dupStr);
        System.out.println(countdup);
    }
}