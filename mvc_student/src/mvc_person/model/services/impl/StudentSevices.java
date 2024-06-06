package mvc_person.model.services.impl;

import mvc_person.model.Student;
import mvc_person.model.repositories.StudentRepository;
import mvc_person.model.services.IStudentServices;

import java.util.*;

public class StudentSevices implements IStudentServices {
    private StudentRepository studentRepository = new StudentRepository();

    public boolean validateInput(Student student) {
        // kiem tra du lieu ng dung nhap vao
        if (student.getName().equals("")) {
            return false;
        }
        if (student.getAddress().equals("")) {
            return false;
        }
        if (student.getClassroom().equals("")) {
            return false;
        }
        if (student.getId() < 0 || student.getId() > 100) {
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Student student) {
        if (validateInput(student)) {
            studentRepository.addStudent(student);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student findByCode(int code) {

        return studentRepository.findByCode(code);
    }

    @Override
    public void removeStudent(Student student) {
        studentRepository.removeStudent(student);
    }

    @Override
    public void editStudent(Student student) {
        if (validateInput(student)) {
            studentRepository.editStudent(student);
        }
    }

        @Override
    public List<Student> searchByName(String name) {
        List<Student> students = this.getAll();
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().lastIndexOf(name) >= 0) {
                result.add(student);
            }
        }
        return result;
    }
//
//
//    public List<Student> searchByName(String name) {
//        List<Student> students = this.getAll();
//
//        // Sắp xếp danh sách theo tên
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//
//        int left = 0;
//        int right = students.size() - 1;
//        List<Student> result = new ArrayList<>();
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (students.get(mid).getName().contains(name)) {
//                // Tìm tất cả các sinh viên có cùng tên ở cả hai phía của vị trí giữa
//                int i = mid;
//                while (i >= 0 && students.get(i).getName().contains(name)) {
//                    result.add(students.get(i));
//                    i--;
//                }
//                i = mid + 1;
//                while (i < students.size() && students.get(i).getName().contains(name)) {
//                    result.add(students.get(i));
//                    i++;
//                }
//                break;
//            } else if (students.get(mid).getName().compareTo(name) < 0) {
//                left = mid + 1;
//            } else if (students.get(mid).getName().compareTo(name) > 0) {
//                right = mid - 1;
//            }
//        }
//        return result;
//    }
}
