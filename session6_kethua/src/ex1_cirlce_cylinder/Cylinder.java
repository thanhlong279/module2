package ex1_cirlce_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea()*height;
    }

    @Override
    public double getArea() {
        return getPerimeter()*height;
    }

    @Override
    public String toString() {
        return "Hình trụ bán kính ="
                + getRadius()
                +" chiều cao:"
                +getHeight()
                +"diện tích: "
                + getArea()
                +"thể tích"
                + getVolume();
    }
}
