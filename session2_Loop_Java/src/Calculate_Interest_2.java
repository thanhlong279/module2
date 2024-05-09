import java.util.Scanner;

public class Calculate_Interest_2 {
    public static void main(String[] args) {
        double money;
        int month;
        double interestRate;

        Scanner input = new Scanner(System.in);

        System.out.println("nhập số tiền gửi: ");
        money = input.nextDouble();

        System.out.println(" nhập số tháng gửi: ");
        month = input.nextInt();

        System.out.println(" nhập lãi xuất: ");
        interestRate = input.nextDouble();

        double totalMoney = calculateInterest(money, month, interestRate);
        System.out.println("tổng số tiền nhận về khi gửi " + money + "trong" + month + " với lãi xuất " + interestRate + " là: " + totalMoney);
    }

    public static double calculateInterest(double money, int month, double interestRate) {
        for (int i = 1; i <= month; i++) {
            money += money * interestRate / 100;
        }
        return money;
    }
}
