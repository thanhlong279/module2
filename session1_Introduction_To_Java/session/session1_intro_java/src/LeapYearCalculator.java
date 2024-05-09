import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        year =  sc.nextInt();
//        if(year % 4 == 0){
//            if(year %100 == 0){
//                if(year % 400 == 0){
//                    System.out.println("năm" + year + "là năm nhuận");
//                }else{
//                    System.out.println("năm" + year + " ko phải là năm nhuận");
//                }
//            }else{
//                System.out.println("năm" + year + " là năm nhuận");
//            }
//        }else{
//            System.out.println("năm" + year + " ko phải là năm nhuận");
//        }
        boolean isLeapYear = false;
        if(year % 4 ==0){
            if(year % 100 ==0){
                if(year % 400 == 0) {
                    isLeapYear = true;
                    }
                }else{
                isLeapYear = true;
            }
        }
        if(isLeapYear){
            System.out.println("năm " + year + " là năm nhuận");
        }else{
            System.out.println("năm " + year + " là năm ko nhuận");
        }
    }
}
