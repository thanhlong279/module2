package paractice;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
    public static int[] inputPoint(){
        int size;
        int[] array;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("nhap do dai cho mang: ");
            size = sc.nextInt();
            if (size <= 0) {
                System.out.println("do dai cua mang lon hon 0.");
            }
        }while (size <= 0);
        // nhập giá trị cho các phần tử mảng:
        array = new int[size];
        for (int i = 1; i < size; i++) {
            System.out.println("nhập điểm cho học sinh " + i + " : ");
            array[i] = sc.nextInt();
            if (array[i] < 0 || array[i] > 10) {
                System.out.println("điểm nằm trong khoảng từ 0 -10");
                array[i] = sc.nextInt();
            }
        }
        return array;
    }
    public static void printPoint(int[] array){
        int count = 0;
        System.out.print("danh sách điểm: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n số học sinh có điểm số lớn hơn 5 là: " + count);
    }
    public static void main(String[] args) {
        printPoint(inputPoint());
    }
}
