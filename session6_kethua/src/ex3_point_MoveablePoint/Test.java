package ex3_point_MoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(5, 4);

        System.out.println(p1);
        System.out.println(p2);

        MoveablePoint mp1 = new MoveablePoint();
        MoveablePoint mp2 = new MoveablePoint(4, 5);
        Point mp3 = new MoveablePoint(5, 4);

        System.out.println(mp1);
        System.out.println(mp2);
        System.out.println(mp3);
        System.out.println(" tọa độ mp2 sau khi tăng speed: ");
        System.out.println(mp2.move());
    }
}
