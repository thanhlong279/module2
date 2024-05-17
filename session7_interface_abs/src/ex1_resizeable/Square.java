package ex1_resizeable;

public class Square extends Rectangle implements Resizeable, IColorable{
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double width, double height) {
        super(color, filled, width, height);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }
    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "Hình vuông cạnh: "
                + getSide()
                +" diện tích: "
                + getArea()
                +"chu vi: "
                + getPerimeter();
    }

    @Override
    public void howToColor(){
        System.out.println("Color all four sides");
    }
}
