package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_MergeArray {
    // gộp mảng
    public static void main(String[] args) {
        int[] arr1 = inputArray();
        System.out.print("mang 1: " + Arrays.toString(arr1));
        System.out.println();
        int[] arr2 = inputArray();
        System.out.println("mang 2: " + Arrays.toString(arr2));
        System.out.println();

        int[] newArr = mergeArray(arr1,arr2);
        System.out.println("mang1 + mang2 la: " + Arrays.toString(newArr));
    }
    public static int[] inputArray(){
        int size;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(" nhap kich thuoc mang : ");
            size = sc.nextInt();
            if(size <= 0)
                System.out.println("moi ban nhap lai, do dai mang  lon hon 0;");
        } while (size <= 0);
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhap phan tu " +i+ " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static int[] mergeArray(int[] array1, int[] array2){
        int[] newArray = new int[array1.length+array2.length];
        // duyệt mảng arr1:
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            newArray[array1.length + j] = array2[j];
        }
        return newArray;
    }
}
