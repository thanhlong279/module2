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
        return new Student(code, name, address, classroom);
    }

    public void viewMessageAdd(boolean result) {
        if (result) {
            System.out.println("them moi thanh cong");
        } else {
            System.out.println("them moi that bai");
        }
    }

    public void viewDisplay(Student[] students) {
        System.out.println(" danh sách sinh viên: ");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public int viewDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập code cần xóa: ");
        int codeDelete = Integer.parseInt(sc.nextLine());
        return codeDelete;
    }

    public void viewMessageDelete(boolean result) {
        if (result) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa thất bại, code ko tồn tại");
        }
    }

    public int viewEdit(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập mã sinh viên cần sửa: ");
        int codeEdit = Integer.parseInt(sc.nextLine());
        return codeEdit;
    }

    public Student editStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new code: ");
        int code = Integer.parseInt(sc.nextLine());
        System.out.print("Input new name: ");
        String name = sc.nextLine();
        System.out.print("Input new address: ");
        String address = sc.nextLine();
        System.out.print("Input new classroom: ");
        String classroom = sc.nextLine();
        return new Student(code, name, address, classroom);
    }

    public void viewMessageEdit(boolean result) {
        if (result) {
            System.out.println("sửa thành công");
        } else {
            System.out.println("sửa thất bại, code ko tồn tại");
        }
    }
}
