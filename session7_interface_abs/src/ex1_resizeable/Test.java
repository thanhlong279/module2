package ex1_resizeable;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // tạo 1 mảng các hình
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(10);


        Random rand = new Random();

        for (Resizeable shape : shapes) {
            double initialArea = 0;
            double newArea = 0;
            if (shape instanceof Circle) {
                initialArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                initialArea = ((Rectangle) shape).getArea();
            } else {
                initialArea = ((Square) shape).getArea();
            }
            System.out.println("diện tích trước khi tăng: " + initialArea);
            // tăng kích thước:
            double percent = 1 + rand.nextInt(100);
            shape.resize(percent);
            if (shape instanceof Circle) {
                newArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                newArea = ((Rectangle) shape).getArea();
            } else {
                newArea = ((Square) shape).getArea();
            }
            System.out.println("diện tích sau khi tăng: " + newArea);
        }
    }
}

