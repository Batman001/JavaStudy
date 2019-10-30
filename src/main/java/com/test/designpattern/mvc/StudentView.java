package com.test.designpattern.mvc;

/**
 * @author Batman create on 2019-04-24 16:26
 * 第二步:创建视图
 */
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student:");
        System.out.println("Name:" + studentName);
        System.out.println("Roll No.:" + studentRollNo);

    }


}
