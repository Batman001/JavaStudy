package com.company.caini.digitstring;

/**
 * Created by sunchao on 2018/7/6.
 */
public interface IStringBuffer {
    public void append(String str);
    public void append(char c);
    public void insert(int pos, char b);
    public void insert(int pos, String b);
    public void delete(int start);
    public void delete(int start, int end);
    public void reverse();
    public int length();
}
