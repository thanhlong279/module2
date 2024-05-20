package mvc.controllers;

import mvc.models.Student;
import mvc.services.IStudentService;
import mvc.services.impl.StudentService;
import mvc.views.StudentView;

public class MainController {
    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        IStudentService studentService = new StudentService();
        int choice;
        int inputCode;
        Student student;
        boolean result;
        while (true) {
            choice = studentView.view();
            switch (choice) {
                case 1:
                    student = studentView.viewAdd();
                    result = studentService.add(student);
                    studentView.viewMessageAdd(result);
                    break;
                case 2:
                    inputCode = studentView.inputCode();
                    result = studentService.edit(inputCode);
                    studentView.viewMessageEdit(result);
                    break;
                case 3:
                    inputCode = studentView.inputCode();
                    result = studentService.delete(inputCode);
                    studentView.viewMessageDelete(result);
                    break;
                case 4:
                    Student[] students = studentService.getAll();
                    studentView.viewDisplay(students);
                    break;
                case 0:
                    return;
            }
        }
    }
}
