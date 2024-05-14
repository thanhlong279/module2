package paractice1_student;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";


    // hàm tạo để khởi tạo đối tượng

    public Student(int r, String n) {
        this.rollno = r;
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    // phương thức tĩnh để thay đổi biến tĩnh
    static void change() {
        college = "ABC";
    }

    // phương thức hiển thị giá trị
    void display(){
        System.out.println(rollno + " " + name + " " + college);
    }
}
