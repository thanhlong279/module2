package mvc.services.impl;

import mvc.models.Student;
import mvc.repositories.StudentRepositories;
import mvc.services.IStudentService;

public class StudentService implements IStudentService {
    private StudentRepositories studentRepositories = new StudentRepositories();

    @Override
    public boolean add(Student student) {
        //kiểm tra dữ liệu
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
        studentRepositories.add(student);
        return true;
    }

    @Override
    public Student[] getAll() {
        return studentRepositories.getAll();
    }


}