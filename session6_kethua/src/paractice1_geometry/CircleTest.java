package paractice1_geometry;

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c);

        Circle c2 = new Circle(5);
        System.out.println(c2);

        Circle c3 = new Circle(3, "black", false);
        System.out.println(c3);
    }
}
