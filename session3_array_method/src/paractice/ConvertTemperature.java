package paractice;

import java.util.Scanner;

public class ConvertTemperature {
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (9.0/5)*celsius+32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (5.0/9)*(fahrenheit-32);
        return celsius;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius;
        double fahrenheit;
        int choice;
        // tạo menu
        do {
            System.out.println("Menu.");
            System.out.println("1. F to C");
            System.out.println("2. C to F");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println(" nhập độ F: ");
                    fahrenheit = sc.nextDouble();
                    System.out.println("F to C: "+ fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println(" nhập độ C: ");
                    celsius = sc.nextDouble();
                    System.out.println(" C to F: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        }while(choice != 0);
    }
}
