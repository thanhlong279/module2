import java.util.Scanner;

public class Ex2_MoneyChange {
    public static void main(String[] args) {
        double rate = 23000;

        Scanner sc = new Scanner(System.in);
        System.out.println(" mời bạn nhập số USD muốn quy đổi: ");
        double usd = sc.nextDouble();
        double vnd = usd*rate;

        System.out.println(usd + " đổi đc " + vnd + " VNĐ");
    }
}
