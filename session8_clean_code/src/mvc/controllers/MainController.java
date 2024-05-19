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
        int codeEdit;
        int codeDelete;
        Student student = null;
        boolean result;
        boolean resultDelete;
        boolean resultEdit;
        while (true) {
            choice = studentView.view();
            switch (choice) {
                case 1:
                    student = studentView.viewAdd();
                    result = studentService.add(student);
                    studentView.viewMessageAdd(result);
                    break;
                case 2:
                    codeEdit = studentView.viewEdit();
                    resultEdit = studentService.edit(codeEdit);
                    studentView.viewMessageEdit(resultEdit);
                    break;
                case 3:
                    codeDelete = studentView.viewDelete();
                    resultDelete = studentService.delete(codeDelete);
                    studentView.viewMessageDelete(resultDelete);
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
