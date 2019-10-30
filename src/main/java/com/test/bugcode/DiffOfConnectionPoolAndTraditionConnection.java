package com.test.bugcode;

/**
 * Created on 2018/10/26.
 * @author Batman
 * Wrong Code
 */
public class DiffOfConnectionPoolAndTraditionConnection {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        com.test.bugcode.TraditionConnectionThread tct = new com.test.bugcode.TraditionConnectionThread(100);
        tct.insertData();
        long end = System.currentTimeMillis();
        System.out.println("使用传统数据库方式,创建100个线程向数据库插入数据,共计耗时"
                + (end-start) + "毫秒");

        long start1 = System.currentTimeMillis();
        ConnectionPoolThread cpt = new ConnectionPoolThread(100, 10);
        cpt.insertData();
        long end1 = System.currentTimeMillis();
        System.out.println("使用数据库连接池方式,创建100个线程向数据库插入数据,共计耗时"
                + (end1-start1) + "毫秒");
    }

}
