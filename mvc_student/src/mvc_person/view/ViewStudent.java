package mvc_person.view;

import mvc_person.model.Student;

import java.util.List;
import java.util.Scanner;

public class ViewStudent {
    public int view() {
        System.out.println("--------StudentView--------");
        System.out.println("1. add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. Display");
        System.out.println("5. student search by name");
        System.out.println("0. Edit");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.println("Input your choice");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("code là số nguyên dương lớn hơn 0");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

    public Student viewAdd() throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        System.out.println("input code");
        int code = Integer.parseInt(sc.nextLine());
        if(code < 0){
            throw new NumberFormatException("code ko phai la so âm");
        }
        System.out.println("input name");
        String name = sc.nextLine();
        System.out.println("input address");
        String address = sc.nextLine();
        System.out.println("input classrooom");
        String classroom = sc.nextLine();
        Student student = new Student(code, name, address, classroom);
        return student;
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");
        }

    }

    public void displayAll(List<Student> students) {
        System.out.println(" danh sach sinh vien: ");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public int inputCode() {
        Scanner sc = new Scanner(System.in);
        int code = -1;
        do {
            try {
                System.out.println("moi ban nhap code: ");
                code = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println(" code la so nguyen lon hon 0");
            }
        }while (code <= 0);
        return code;
    }

    public void displayMessageNotFound() {
        System.out.println(" ko tim thay");
    }

    public boolean confirmDelete(Student student) {
        System.out.println(" ban co muon xoa sinh vien co code la " + student.getId() + "bam Y de xac nhan, bam N de huy");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public String inputName() {
        System.out.println(" nhập tên: ");
        return new Scanner(System.in).nextLine();
    }

    public boolean confirmEdit(Student student) {
        System.out.println("bạn có muốn sửa thông tin sinh viên có id: " + student.getId() + "bấm Y để xác nhận, N để hủy");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
