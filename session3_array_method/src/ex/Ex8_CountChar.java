package ex;

import java.util.Scanner;

public class Ex8_CountChar {
    // đếm số lần xuất hiện của kí tự trong chuỗi
    public static void main(String[] args) {

        String str = "hello world!";
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập kí tự tìm kiếm: ");
        char ch = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự '" + ch + "' trong chuỗi là: " + count);
    }
}
