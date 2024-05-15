package ex2_point2d_point3d;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        Point2D point2D1 = new Point2D(5,4);

        System.out.println(point2D);
        System.out.println(point2D1);

        Point2D point3D = new Point3D();
        Point2D point3D1 = new Point3D(5);
        Point2D point3D2 = new Point3D(4,3,6);

        System.out.println(point3D);
        System.out.println(point3D1);
        System.out.println(point3D2);
    }
}
