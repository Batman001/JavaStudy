package com.company.caini.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchao on 2018/10/19.
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicI = new AtomicInteger();
        int i = atomicI.decrementAndGet();
        int j = atomicI.incrementAndGet();
        int k = atomicI.addAndGet(3);
    }
}
