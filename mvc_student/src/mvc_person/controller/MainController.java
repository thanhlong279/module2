package mvc_person.controller;

import mvc_person.model.Student;
import mvc_person.model.services.IStudentServices;
import mvc_person.model.services.impl.StudentSevices;
import mvc_person.view.ViewStudent;

import java.util.List;

public class MainController {
    public static void main(String[] args) {
        ViewStudent viewstudent = new ViewStudent();
        IStudentServices studentServices = new StudentSevices();
        Student student;
        String name;
        boolean result;
        int code;
        while (true) {
            int choice = viewstudent.view();
            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            student = viewstudent.viewAdd();
                            result = studentServices.add(student);
                            viewstudent.viewMessage(result);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    code = viewstudent.inputCode();
                    student = studentServices.findByCode(code);
                    if (student == null) {
                        viewstudent.displayMessageNotFound();
                    } else {
                        boolean isConfirm = viewstudent.confirmEdit(student);
                        if (isConfirm) {
                            student = viewstudent.viewAdd();
                            studentServices.editStudent(student);
                            viewstudent.viewMessage(true);
                        }
                    }
                    break;
                case 3:
                    code = viewstudent.inputCode();
                    student = studentServices.findByCode(code);
                    if (student == null) {
                        viewstudent.viewMessage(false);
                    } else {
                        boolean isConfirm = viewstudent.confirmDelete(student);
                        if (isConfirm) {
                            studentServices.removeStudent(student);
                            viewstudent.viewMessage(true);
                        }
                    }
                    break;
                case 4:
                    List<Student> students = studentServices.getAll();
                    viewstudent.displayAll(students);
                    break;
                case 5:
//                    String name = viewstudent.inputName();
//                    result = ((StudentSevices) studentServices).searchByName(name);
//                    if(result) {
//                        students = studentServices.listSearchByName(name);
//                        viewstudent.displayAll(students);
//                    }else{
//                        viewstudent.displayMessageNotFound();
//                    }
                    name = viewstudent.inputName();
                    students = studentServices.searchByName(name);
                    if (students.isEmpty()) {
                        viewstudent.displayMessageNotFound();
                    } else {
                        viewstudent.displayAll(students);
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
