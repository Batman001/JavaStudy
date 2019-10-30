package com.test.genericall;

/**
 * @author Batman create on 2019-05-21 15:25
 */
public interface Generator<T> {
    /**
     * next方法 返回一个对象
     * @return 对应的T对象
     */
    T next();
}
