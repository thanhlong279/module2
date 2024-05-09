import java.util.Scanner;

public class Ex3_RedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Mời bạn nhập số cần đọc (từ 0 đến 999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập một số nguyên!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < 0 || number > 999);
        String result = "";
        if(number < 10){
            result = readSingleDigit(number);
        }else if(number < 20){
            result = readDoubleDigitLessThan20(number);
        }else if(number < 100){
            result = readDoubleDigitGreaterThan20(number);
        }else{
            result = readTripleDigit(number);
        }
        System.out.println(result);
    }

    private static String readTripleDigit(int number) {
        int hundreds = number / 100;
        int remaining = number % 100;
        String hundredsStr = readSingleDigit(hundreds) + " hundred ";
        String remainingStr = "";
        if(remaining != 0){
            if(remaining < 10){
                remainingStr = readSingleDigit(remaining);
            }else if(remaining < 20){
                remainingStr = readDoubleDigitLessThan20(remaining);
            }else{
                remainingStr = readDoubleDigitGreaterThan20(remaining);
            }
        }
        return hundredsStr + " and " + remainingStr;
    }
    // number > 20 && < 100
    private static String readDoubleDigitGreaterThan20(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String tenStr = "";
        String onesStr = "";
        switch (tens){
            case 2:
                tenStr = "twenty";
                break;
            case 3:
                tenStr = "thirty";
                break;
            case 4:
                tenStr = "fourty";
                break;
            case 5:
                tenStr = "fifty";
                break;
            case 6:
                tenStr = "sixty";
                break;
            case 7:
                tenStr = "seventy";
                break;
            case 8:
                tenStr = "eighty";
                break;
            case 9:
                tenStr = "ninety";
                break;
            default:
                break;
        }
        if(ones != 0){
            onesStr = readSingleDigit(ones);
        }
        return tenStr + " " + onesStr;
    }
    // nếu number < 10 hàm readSingleDigit hàm sẽ đc gọi
    public static String readSingleDigit(int number){
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
    // number > 10 && bé hơn 20
    public static String readDoubleDigitLessThan20(int number){
        switch (number){
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }
}
