package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_MinArray {
    //tìm giá trị nhỏ nhất của mảng
    public static void main(String[] args) {
        System.out.print(" mang arr: " + Arrays.toString(inputArray()));
        System.out.println();
        System.out.println("gia tri nho nhat trong mang: "+ minArray(inputArray()));

    }

    public static double[] inputArray(){
        Scanner sc = new Scanner(System.in);

        int size;
        double[] arr;

        do {
            System.out.println("nhập kích thước cho mảng: ");
            size = sc.nextInt();
            if(size < 0){
                System.out.println("nhập lại, kích thước của mảng lớn hơn 0");
            }
        }while (size < 0);

        arr = new double[size];
        for (int i = 0; i < size; i++) {
            System.out.println(" nhập phần tử " +i+ " : ");
            arr[i] = sc.nextDouble();
        }
        return arr;
    }

    public static double minArray(double[] array){
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
