package demo;

public class Main {
    public static void main(String[] args) {
        int []a = {1, 2, 3};
        Student s = new Student(a,1, "KA");
        System.out.println(s);
//        chi lay ra dc du lieu
        int[] b = s.getSoDo3();
        b[2]=5;
        System.out.println(s);
    }
}
