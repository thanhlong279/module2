package ex1_quadratic_quation_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap a: ");
        double a = sc.nextDouble();
        System.out.println(" nhap b: ");
        double b = sc.nextDouble();
        System.out.println(" nhap c: ");
        double c = sc.nextDouble();

        QuadraticEquation_2 equation = new QuadraticEquation_2(a, b, c);
    }
}
