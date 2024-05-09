import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double a;
        double b;

        Scanner sc = new Scanner(System.in);

        System.out.println(" nhap a: ");
        a = sc.nextDouble();

        System.out.println(" nhap b: ");
        b = sc.nextDouble();
        double x = -b / a;
        if (a != 0){
            System.out.println(" pt co nghiem x = " + x);
        }else{
            if(b == 0){
                System.out.println(" pt co vo so nghiem");
            }else{
                System.out.println(" pt vo nghiem");
            }
        }
    }
}