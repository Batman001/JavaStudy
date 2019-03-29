package com.company.caini.digitstring;

import java.util.Arrays;

/**
 * Created by Batman on 2018/7/6.
 */
public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    char[] chars;
    int length = 0;

    // 无参构造函数
    public MyStringBuffer(){
        chars = new char[capacity];
    }

    // 有参构造函数
    public MyStringBuffer(String str){
        if(null != str)
         chars = str.toCharArray();
        length = chars.length;
        if(capacity < chars.length)
            capacity = chars.length * 2;
        if(capacity >= chars.length)
            System.arraycopy(str.toCharArray(), 0, length, 0, str.length());
        length = str.length();
    }

    @Override
    public void append(String str) {
        while(true){
            if(chars.length < (length + str.length()))
                chars = Arrays.copyOf(chars, chars.length + 20);
            else
                break;
            for(int i=0;i<str.length();i++){
                chars[length + i] = str.charAt(i);
            }
            length += str.length();
        }
    }

    @Override
    public void append(char c) {
        if(chars.length < length + 1)
            chars = Arrays.copyOf(chars, chars.length + 20);
        chars[length] = c;
        length ++;

    }

    @Override
    public void insert(int pos, char b) {
        if(chars.length < length +1)
            chars = Arrays.copyOf(chars, chars.length + 20);
        for(int i=length;i>=pos;i--){
            chars[i+1] = chars[i];
        }
        chars[pos] = b;
        length ++;

    }

    @Override
    public void insert(int pos, String b) {
        while(true){
            if(chars.length < length+b.length())
                chars = Arrays.copyOf(chars, chars.length + 20);
            else
                break;
        }
        for (int i=length;i>=pos;i--){
            chars[i+b.length()] = chars[i];
        }
        for(int i=0;i<b.length();i++){
            chars[pos+i] = b.charAt(i);
        }
        length += b.length();

    }

    @Override
    public void delete(int start) {
        for(int i=start;i<=length;i++){
            chars[i] = '\0';
        }
        length = start;

    }

    @Override
    public void delete(int start, int end) {
        for(int i=start;i<=length;i++){
            chars[i-1] = chars[i+end-start-1];
            chars[i+end-start-1] = '\0';
        }
        length = length - end + start;

    }

    @Override
    public void reverse() {
        for(int i=0; i<length/2; i++){
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length-i] = temp;
        }

    }

    @Override
    public int length() {
        return length;
    }

    public static void main(String[] args){
        MyStringBuffer msb = new MyStringBuffer("there light");
        msb.reverse();

        System.out.println(msb);
    }
}
