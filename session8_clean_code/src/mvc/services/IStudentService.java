package mvc.services;

import mvc.models.Student;

public interface IStudentService {
    boolean add(Student student);

    Student[] getAll();

    boolean delete(int codeDelete);
}
