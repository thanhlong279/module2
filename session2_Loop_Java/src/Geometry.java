import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while( choice != 0){
            System.out.println(" Menu ");
            System.out.println("1. Vẽ hình tam giác(triangle)");
            System.out.println("2. Vẽ hình vuông(square)");
            System.out.println("3. Vẽ hình chữ nhật(rectangle)");
            System.out.println("0. Exit");
            System.out.println("mời bạn chọn chức năng: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println(" vẽ hình tam giác(triangle)");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println(" vẽ hình vuông(square)");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    break;
                case 3:
                    System.out.println(" vẽ hình chữ nhật(rectangle)");
                    System.out.println("*****");
                    System.out.println("*****");
                    System.out.println("*****");
                    break;
                    case 0:
                        System.exit(0);
                default:
                    System.out.println(" No Choice!");
            }
        }
    }
}
