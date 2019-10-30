package com.test.digitstring;

/**
 * Created by Batman on 2018/7/6.
 */
public class TestString3 {
    public static void main(String[] args){
        String str1 = "let there ";
        StringBuffer sb = new StringBuffer(str1); // 根据str1创建一个StringBuffer的对象
        sb.append("be light");  // append添加操作
        System.out.println(sb);

        sb.delete(4,10);  // 删除4-10之间的字符
        System.out.println(sb);

        sb.insert(4, "there "); // 在4这个位置上插入 there
        System.out.println(sb);

        sb.reverse();
        //System.out.println(sb);  // 字符串反转

        System.out.println(sb.length());



        // 测试StringBuffer与String拼接的性能

        String init = " ";
        StringBuffer sbTest = new StringBuffer();

        String randomStr = CombineTest.randomString(10);

        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            init += randomStr;
        }
        long end = System.currentTimeMillis();

        System.out.printf("使用字符串拼接共计%d次,共耗时%d毫秒%n",10000, end-start);

        for(int i=0;i<10000;i++){
            sbTest.append(randomStr);
        }
        long end2 = System.currentTimeMillis();
        System.out.printf("使用StringBuffer连接的方式共计%d次,共耗时%d毫秒%n",10000, end2-end);



    }


}
