import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        double weight;
        double height;
        double bmi;
        Scanner sc = new Scanner(System.in) ;

        System.out.println(" nhập weight: ");
        weight = sc.nextDouble() ;


        System.out.println(" nhập height: ");
        height = sc.nextDouble();

        bmi = weight / (height * height);

        System.out.println(bmi);

        if(bmi < 18){
            System.out.println("Underweight");
        }else if(bmi < 25){
            System.out.println("Normal");
        }else if(bmi < 30){
            System.out.println("Overweight");
        }else{
            System.out.println("Obese");
        }
    }
}
