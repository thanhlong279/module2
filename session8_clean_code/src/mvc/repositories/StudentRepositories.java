package mvc.repositories;

import mvc.models.Student;

public class StudentRepositories {
    private static Student[] arrStudent = new Student[100];
    private static int count = 0;

    static {
        arrStudent[0] = new Student(1, "HaiTT", "Quang Nam", "C0324H1");
        count = 1;
    }

    public void add(Student student) {
        arrStudent[count] = student;
        count++;
    }

    //sao chép sang mảng mới để bảo đảm tính bao đóng dữ liệu
    public Student[] copy() {
        Student[] newStudent = new Student[count];
        for (int i = 0; i < count; i++) {
            newStudent[i] = arrStudent[i];
        }
        return newStudent;
    }

    public boolean delete(int codeDelete) {
        for (int i = 0; i < count; i++) {
            if (arrStudent[i].getCode() == codeDelete) {
                for (int j = i; j < count - 1; j++) {
                    arrStudent[j] = arrStudent[j + 1];
                }
                arrStudent[--count] = null;
                return true;
            }
        }
        return false;
    }

}
