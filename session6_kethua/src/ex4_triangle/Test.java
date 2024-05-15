package ex4_triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double side1;
        double side2;
        double side3;
        while (true) {
            System.out.println("nhập 3 cạnh của tam giác:");
            System.out.println("cạnh 1: ");
            side1 = sc.nextDouble();
            System.out.println("cạnh 2: ");
            side2 = sc.nextDouble();
            System.out.println("cạnh 3: ");
            side3 = sc.nextDouble();

            Triangle triangle = new Triangle(side1, side2, side3);
            if (triangle.isTriangle()) {
                System.out.println(triangle);
            } else {
                System.out.println(" 3 cạnh trên ko đủ điều kiện để tạo thành 1 tam giác");
            }
        }

    }
}
