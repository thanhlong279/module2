package paractice;

import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {
        int size;
        int[] array;

        Scanner sc = new Scanner(System.in);
        // nhập và kiểm tra kích thước mảng
        do {
            System.out.print(" nhập kích thước mảng: ");
            size = sc.nextInt();
            if(size > 20 || size <= 0)
                System.out.println(" kích thước mảng là số nguyên dương và ko vượt quá 20!");
        }while(size > 20);
        array = new int[size];
        int i = 0;
        while (i < size){
            System.out.println("nhập phần tử thứ :" + (i+1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.print("các phần tử trong mảng: ");
        for (int j = 0; j < size; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.println();
        for (int j = 0; j < size/2; j++) {
            int temp = array[j];
            array[j] = array[size-1-j];
            array[size-1-j] = temp;
        }
        System.out.print(" mảng sau khi đảo ngược: ");
        for (int j = 0; j < size; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
