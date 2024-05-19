package mvc.services;

import mvc.models.Student;
import mvc.views.StudentView;

public interface IStudentService {
    boolean add(Student student);

    Student[] getAll();

    boolean delete(int codeDelete);

    boolean edit(int codeEdit);

//    boolean validateCode(int code);

}
