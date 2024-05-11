package paractice;

import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" nhập kích thước cho mảng: ");
            size = sc.nextInt();
            if (size > 20 || size <= 0) {
                System.out.println(" kích thước của mảng lớn hơn 0 và bé hơn 20.");
            }
        } while (size > 20 || size <= 0);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println(" nhập phần tử thứ " + i + " : ");
            array[i] = sc.nextInt();
        }
        System.out.print(" các phần tử trong mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " \t");
        }
        System.out.println();
        int max = array[0];
        int index = 1;
        for (int j = 0; j < size; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("giá trị lớn nhất là :" + max + " ở vị trí thứ " + index + " trong mảng");
    }
}
