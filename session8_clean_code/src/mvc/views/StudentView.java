package mvc.views;

import mvc.models.Student;

import java.util.Scanner;

public class StudentView {
    public int view() {
        System.out.println("StudentView");
        System.out.println("1. Add student ");
        System.out.println("2. Edit student ");
        System.out.println("3. Delete student ");
        System.out.println("4. Display student ");
        System.out.println("0. Exit");
        System.out.println(" mời bạn chọn chức năng: ");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public Student viewAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" input code: ");
        int code = Integer.parseInt(sc.nextLine());
        System.out.print(" input name: ");
        String name = sc.nextLine();
        System.out.print(" input address: ");
        String address = sc.nextLine();
        System.out.print(" input classroom: ");
        String classroom = sc.nextLine();
        Student student = new Student(code, name, address, classroom);
        return student;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("them moi thanh cong");
        } else {
            System.out.println("them moi that bai");
        }
    }

    public void viewDisplay(Student[] student) {
        for (Student students : student) {
            System.out.println(student.toString());
        }
    }
}
