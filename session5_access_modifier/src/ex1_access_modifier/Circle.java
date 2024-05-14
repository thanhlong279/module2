package ex1_access_modifier;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1;
        this.color = "red";

    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

     double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

     double getArea(){
        return radius*radius*Math.PI;
    }
}
