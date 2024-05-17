package paractice1_geometry;

import java.util.Arrays;

public class ComparebleCircleTest {
    public static void main(String[] args) {
        ComparebleCircle[] circle = new ComparebleCircle[3];
        circle[0] = new ComparebleCircle();
        circle[1] = new ComparebleCircle(4.5);
        circle[2] = new ComparebleCircle(3.1, "blue", false);

        System.out.println("trước sắp xếp : ");
        for (ComparebleCircle c : circle) {
            System.out.println(c);
        }

        Arrays.sort(circle);
        System.out.println("sau sắp xếp");
        for (ComparebleCircle c : circle) {
            System.out.println(c);
        }
    }
}
