package paractice1_geometry;

public class SquareTest {
    public static void main(String[] args) {
        Rectangle square = new Square();
        Rectangle squar1 = new Square(5);
        Rectangle squar2 = new Square("blue", false, 3);

        System.out.println(square);
        System.out.println(squar1);
        System.out.println(squar2);
    }
}
