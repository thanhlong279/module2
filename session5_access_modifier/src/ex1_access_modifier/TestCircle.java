package ex1_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle(2);
        c.getArea();
        System.out.println(c.getRadius());
        System.out.println(c.getArea());

    }
    // đổi public sang private báo lỗi,2 phương thức này chỉ có thể truy cập từ bên trong lớp Circle, gọi method này bên ngoài class Circle sẽ báo lỗi biên dich
    // public sang default, protected vẫn sử dụng đc vì nó có thể truy cập đc từ các lớp trong cùng package
}
