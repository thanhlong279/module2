package ex4_triangle;

import paractice1_geometry.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0d;
    private double side2 = 1.0d;
    private double side3 = 1.0d;

    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public boolean isTriangle(){
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    public double getArea(){
        return Math.sqrt((getPerimeter()/2)*((getPerimeter()/2-side1))*((getPerimeter()/2-side2))*((getPerimeter()/2-side3)));
    }

    public double getPerimeter(){
        return side1+side2+side3;
    }

    @Override
    public String toString() {
        return "Tam giác {" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                "có diện tích là: " +
                getArea()+
                " và chu vi là: "+
                getPerimeter()+
                '}';
    }
}
