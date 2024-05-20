package mvc.services.impl;

import mvc.models.Student;
import mvc.repositories.StudentRepositories;
import mvc.services.IStudentService;
import mvc.views.StudentView;

public class StudentService implements IStudentService {
    private StudentRepositories studentRepositories = new StudentRepositories();

    // kiểm tra dữ liệu của người dùng nhập vào cô đối tượng student
    public boolean validateStudent(Student student) {
        if (student.getName().equals("")) {
            return false;
        }
        if (student.getCode() < 0 || student.getCode() > 1000) {
            return false;
        }
        if (student.getAddress().equals("")) {
            return false;
        }
        if (student.getClassRoom().equals("")) {
            return false;
        }
       return true;
    }

    @Override
    public boolean add(Student student) {
        if (validateStudent(student)) {
            studentRepositories.add(student);
            return true;
        }
        return false;
    }

    // gọi pt copy của đối tượng studentRepo trả về 1 mảng chứa tất cả các đối tượng student
    @Override
    public Student[] getAll() {
        return studentRepositories.copy();
    }

    @Override
    public boolean delete(int inputCode) {
            return studentRepositories.delete(inputCode);
    }

    @Override
    public boolean edit(int inputCode) {
            return studentRepositories.update(inputCode);
    }

}

