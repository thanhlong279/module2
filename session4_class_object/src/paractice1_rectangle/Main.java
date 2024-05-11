package paractice1_rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" nhập width: ");
        double width = sc.nextDouble();
        System.out.println(" nhập height: ");
        double height = sc.nextDouble();

        // khởi tạo 1 đối tượng thuộc lớp Rectangle với 2 phương thức khởi tạo
        Rectangle rectangle1 = new Rectangle(width, height);

        System.out.println("Your Rectangle \n" + rectangle1.display());
        System.out.println(" diện tích hình chữ nhật: " + rectangle1.getArea());
        System.out.println("chu vi hình chữ nhật: " + rectangle1.getPerimeter());
    }
}
