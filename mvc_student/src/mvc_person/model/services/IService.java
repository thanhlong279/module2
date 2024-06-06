package mvc_person.model.services;

import mvc_person.model.Person;
import mvc_person.model.Student;

import java.util.List;

public interface IService<T extends Person> {
    boolean add(T t);

    List<T> getAll();

    T findByCode(int code);

    void removeStudent(T student);


//    boolean searchByName(String name);
    List<T> searchByName(String name);

    void editStudent(Student student);
}
