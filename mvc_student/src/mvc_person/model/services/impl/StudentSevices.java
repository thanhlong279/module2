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
    public boolean editStudent(Student student) {
        if (validateInput(student)) {
           studentRepository.editStudent(student);
//            student.setId(student.getId());
//            student.setName(student.getName());
//            student.setAddress(student.getAddress());
//            student.setClassroom(student.getClassroom());
            // Lưu thông tin cập nhật vào Repository

            return true;
        }
        return false;
    }

    //    @Override
//    public List<Student> searchByName(String name) {
//        List<Student> students = this.getAll();
//        List<Student> result = new ArrayList<>();
//        for (Student student : students) {
//            if (student.getName().lastIndexOf(name) >= 0) {
//                result.add(student);
//            }
//        }
//        return result;
//    }
//
//    public List<Student> searchByName(String name) {
//        List<Student> students = this.getAll();
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        int left = 0;
//        int right = students.size() - 1;
//        List<Student> result = new ArrayList<>();
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if(students.get(mid).getName().indexOf(name)>=0) {
//                result.add(students.get(mid));
//            }else if(students.get(mid).getName().compareTo(name)<0) {
//                left = mid + 1;
//            }else{
//                right = mid - 1;
//            }
//        }
//        return result;
//    }
    public List<Student> searchByName(String name) {
        List<Student> students = this.getAll();

        // Sắp xếp danh sách theo tên
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        int left = 0;
        int right = students.size() - 1;
        List<Student> result = new ArrayList<>();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (students.get(mid).getName().contains(name)) {
                // Tìm tất cả các sinh viên có cùng tên ở cả hai phía của vị trí giữa
                int i = mid;
                while (i >= 0 && students.get(i).getName().contains(name)) {
                    result.add(students.get(i));
                    i--;
                }
                i = mid + 1;
                while (i < students.size() && students.get(i).getName().contains(name)) {
                    result.add(students.get(i));
                    i++;
                }
                break;
            } else if (students.get(mid).getName().compareTo(name) < 0) {
                left = mid + 1;
            } else if (students.get(mid).getName().compareTo(name) > 0) {
                right = mid - 1;
            }
        }
        return result;
    }

//public List<Student> searchByName(String name) {
//    List<Student> students = this.getAll();
//    Collections.sort(students, new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.getName().compareTo(o2.getName());
//        }
//    });
//
//    List<Student> result = new ArrayList<>();
//    int index = binarySearch(students, name);
//
//    // Nếu không tìm thấy, trả về danh sách rỗng
//    if (index == -1) {
//        return result;
//    }
//
//    // Tìm tất cả các sinh viên có tên chứa chuỗi con name
//    // Kiểm tra các phần tử bên trái
//    int left = index;
//    while (left >= 0 && students.get(left).getName().contains(name)) {
//        result.add(students.get(left));
//        left--;
//    }
//
//    // Kiểm tra các phần tử bên phải
//    int right = index + 1;
//    while (right < students.size() && students.get(right).getName().contains(name)) {
//        result.add(students.get(right));
//        right++;
//    }
//
//    return result;
//}
//    private int binarySearch(List<Student> students, String name) {
//        int left = 0;
//        int right = students.size() - 1;
//        String midName;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            midName = students.get(mid).getName();
//            if (midName.contains(name)) {
//                return mid; // Tìm thấy chuỗi con
//            } else if (midName.compareTo(name) < 0) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1; // Không tìm thấy
//    }
}
