package com.test.designpattern.mvc;

/**
 * @author Batman create on 2019-04-24 16:30
 * 使用 StudentController 方法来演示 MVC 设计模式的用法。
 */
public class MvcPatternDemo {
    public static void main(String[] args) {
        // 获取学生记录
        Student model = retrieveStudentFromDataBase();

        // 创建一个视图:把学生详细信息输出到控制台
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();

        // 更新模型数据
        controller.setStudentName("Robin");
        controller.setStudentRollNo("9528");
        controller.updateView();
        
    }

    private static Student retrieveStudentFromDataBase() {
        Student model = new Student();
        model.setName("Batman");
        model.setRollNo("9527");
        return model;

    }

}
