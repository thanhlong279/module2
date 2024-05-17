package ex1_resizeable;

public class Ex2_Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(5);
        double area = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                area = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                area = ((Rectangle) shape).getArea();
            }else if(shape instanceof Square) {
                area = ((Square) shape).getArea();
            }
            if(shape instanceof IColorable){
                ((IColorable) shape).howToColor();
            }
            System.out.println("dien tich :" +area);
        }
    }
}
