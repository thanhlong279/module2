package mvc_person.model.repositories;

import mvc_person.model.Student;

import java.util.*;

public class StudentRepository {
    //    private static Student[] students = new Student[100];
    // su dung ArrayList:
//    private static int count = 0;
    private static List<Student> students = new ArrayList<>();


    static {
//        students[0] = new Student(1, "HaiTT", "Quang Nam", "C03");
//        count = 1;
        students.add(new Student(1, "HaiTT", "Quang Nam", "Co3"));
//        count = 1;
    }

    public void addStudent(Student student) {
        students.add(student);
//        count++;
    }


    public List<Student> getAll() {
//        List<Student> result = new ArrayList<>();
//        Collections.copy(students, result);
//        return result;
        List<Student> result = new ArrayList<>();
        result.addAll(students);
        return result;
    }

    public Student findByCode(int code) {
        for (Student student : students) {
            if (student == null) {
                return null;
            }
            if (student.getId() == code) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == student.getId()) {
                students.remove(i);
                break;
            }
        }
    }
    public void editStudent(Student student) {
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == student.getId())
                students.set(i, student);
            break;
        }
    }
}
