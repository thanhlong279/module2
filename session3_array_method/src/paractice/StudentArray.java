package paractice;

import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] students = {"Long", "Hoang", "Tinh", "Truong", "Ngoc", "Quyen", "TheAnh", "Dung"};
        Scanner sc = new Scanner(System.in);

        System.out.println(" nhập tên sinh viên: ");
        String str = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            // phương thức equals() so sánh 2 chuỗi và trả về giá trị true false
            if(students[i].equals(str)){
                System.out.println(" vị trí của sinh viên " + str + " trong danh sách: "+ i);
                isExist = true;
                break;
            }
        }
        if(!isExist){
            System.out.println(" ko tìm thấy sinh viên :" + str + " trong danh sách.");
        }
    }
}
