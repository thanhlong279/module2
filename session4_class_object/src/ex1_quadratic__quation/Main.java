package ex1_quadratic__quation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double r1;
        double r2;
        Scanner sc = new Scanner(System.in);

        double a;
        do {
            System.out.println(" nhap a: ");
             a = sc.nextDouble();
            if (a == 0) {
                System.out.println("nhap lai a, pt bac 2 a phai khac 0");
            }
        } while (a == 0);
        System.out.println(" nhap b: ");
        double b = sc.nextDouble();
        System.out.println(" nhap c: ");
        double c = sc.nextDouble();

       QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        if (delta >= 0) {
            r1 = equation.getRoot1();
            r2 = equation.getRoot2();
            System.out.println("pt co 2 nghiem: r1 = " + r1 + " r2 = " + r2);
        } else {
            System.out.println("pt vo nghiem.");
        }

    }
}
