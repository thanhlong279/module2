import java.util.Scanner;

public class Ex1_Hello {
    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println(" mời bạn nhập tên: ");
        name  = sc.nextLine();
        System.out.println(" hello " + name);
    }
}
