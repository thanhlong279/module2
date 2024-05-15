package paractice1_geometry;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rtl1 = new Rectangle();
        Rectangle rtl2 = new Rectangle(4, 5);
        Rectangle rtl3 = new Rectangle("Black", false, 3, 5);

        rtl2.getArea();
        rtl2.getPerimeter();

        System.out.println(rtl1);
        System.out.println(rtl2);
        System.out.println(rtl3);
    }
}
