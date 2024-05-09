import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập a: ");
        a  = sc.nextInt();

        System.out.println(" nhập b: ");
        b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        if(a == 0 || b == 0){
            System.out.println(" ko có ước chung lớn nhất");
        }
        while (a != b){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        System.out.println(" ước chung lớn nhất của 2 số là : " + a);
    }
}
