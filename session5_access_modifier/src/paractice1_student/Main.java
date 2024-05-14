package paractice1_student;

public class Main{
    public static void main(String[] args) {
        // gọi phương thức change()
//        Student.change();


        // tạo đối tượng obj
        Student st1 = new Student(111, "hoang");
        Student st2 = new Student(222, "long");
        Student st3 = new Student(333, "nam");
        // sử dụng setter để thay đổi thuộc tính của đối tượng
        st1.setName("Tinh");
        // gọi phương thức display()
        st1.display();
        st2.display();
        st3.display();
    }
}
