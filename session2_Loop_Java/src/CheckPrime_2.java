import java.util.Scanner;

public class CheckPrime_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập số nguyên cần kiểm tra: ");
        int number = sc.nextInt();
        if(isPrime(number)){
            System.out.println(number + " là số nguyên tố");
        }else{
            System.out.println(number + " ko phải là số nguyên tố");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number < 4) return true;
        for (int i = 2; i < number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
