import java.util.Scanner;

public class Calculate_Interest {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;

        Scanner input = new Scanner(System.in);

        System.out.println("nhập số tiền gửi: ");
        money = input.nextDouble();

        System.out.println(" nhập số tháng gửi: ");
        month = input.nextInt();

        System.out.println(" nhập lãi xuất: ");
        interestRate = input.nextDouble();

        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += month * money * (interestRate/100)/12;
        }
        System.out.println("Tổng tiền lãi là: " + totalInterest);
    }
}
