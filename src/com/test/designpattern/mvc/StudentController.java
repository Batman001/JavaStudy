package com.test.designpattern.mvc;

/**
 * @author Batman create on 2019-04-24 16:28
 * 第三步:创建控制器
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public Student getModel() {
        return model;
    }

    public StudentView getView() {
        return view;
    }

    public void setModel(Student model) {
        this.model = model;
    }

    public void setView(StudentView view) {
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo(){
        return model.getRollNo();
    }


    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
