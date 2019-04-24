package com.test.designpattern.mvc;

/**
 * @author Batman create on 2019-04-24 16:25
 * 第一步:创建模型
 */
public class Student {
    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }
}
