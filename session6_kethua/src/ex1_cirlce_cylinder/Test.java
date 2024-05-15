package ex1_cirlce_cylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "red");
        Circle circle1 = new Circle(3, "red");
        System.out.println(circle);
        System.out.println(circle1);

        Circle cylinder = new Cylinder(5, "red", 10);
        Circle cylinder1 = new Cylinder(3, "red", 10);
        System.out.println(cylinder);
        System.out.println(cylinder1);
    }
}
