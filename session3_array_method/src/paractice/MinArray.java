package paractice;

import java.util.Arrays;
import java.util.Scanner;

public class MinArray {
    // phương thức tìm min
    public static int minArray(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min){
                min =  array[i];
            }
        }
        return min;
    }
    // phương thức nhập mảng:
    public static int[] addArray(){
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("nhập kích thước của mảng: ");
            size = sc.nextInt();
            if(size > 20 || size <=0){
                System.out.println("mời bạn nhập lại, độ dài của mảng lớn ơn 0 là bé hơn 20.");
            }
        }while(size > 20 || size <= 0);
        array = new int[size];

        // nhập phần tử cho mảng:
        for (int i = 0; i < size; i++) {
            System.out.println(" nhập phần tử " +i+ " : ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = addArray();
        int minArr = minArray(array);
        System.out.print("các giá trị trong mảng: " + Arrays.toString(array));
        System.out.println();
        System.out.println("giá trị nhỏ nhất trong mảng là: " + minArr);
    }
}
