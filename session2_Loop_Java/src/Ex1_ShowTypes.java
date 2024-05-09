import java.util.Scanner;

public class Ex1_ShowTypes {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0){
            System.out.println(" Menu: ");
            System.out.println("1. Vẽ hình chữ nhật(rectangle");
            System.out.println("2. vẽ hình tam giác, góc vuông trên cùng trái: ");
            System.out.println("3. vẽ hình tam giác góc vuông trên cùng phải: ");
            System.out.println("4. vẽ hình tam giác góc vuông dưới cùng trái: ");
            System.out.println("5. vẽ hình tam giác góc vuông dưới cunng phải: ");
            System.out.println("6. vẽ hình tam giác cân: ");
            System.out.println("0. Exit: ");
            System.out.println(" mời bạn trọn chức năng: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    drawRectangle();
                    break;
                case 2:
                    drawTriangle1();
                    break;
                case 3:
                    drawTriangle2();
                case 4:
                    drawTriangle3();
                    break;
                case 5:
                    drawTriangle4();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println(" No choice!");
            }
        }
    }

    private static void drawTriangle4() {

    }

    private static void drawTriangle2() {

    }

    private static void drawTriangle3() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawTriangle1() {
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawRectangle(){
        System.out.println(" vẽ hình chữ nhật(rectangle)");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");
    }

}
