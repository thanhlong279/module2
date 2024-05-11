package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_DeleteElement {
    //xóa phần tử khỏi mảng
    public static int[] inputArray() {
        int size;
        int[] arr;

        Scanner sc = new Scanner(System.in);

        // nhập kích thước cho mảng:
        do {
            System.out.println(" nhập kích thước cho mảng: ");
            size = sc.nextInt();
            if (size > 20 || size <= 0) {
                System.out.println("mời bạn nhập lại, kích thước mảng phải lớn hơn 0 và nhỏ hơn 20.");
            }
        } while (size > 20 || size <= 0);
        // nhập phần tử cho mảng:
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println(" nhập phần tử " + i + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[] deleteElement(int[] array, int x) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                index = i;
                break;
            }
        }
        // nếu ko tìm thấy trả về mảng ban đầu
        if (index == -1) {
            return array;
        }else {
            //xóa phần tử x ở vị trí index
            for (int i = index; i < (array.length - 1); i++) {
                array[i] = array[i + 1];
            }
            int[] newArray = Arrays.copyOf(array, array.length - 1);
            return newArray;
        }
    }

    public static void main(String[] args) {

        int[] arr = inputArray();
        System.out.print("Mảng arr: " + Arrays.toString(arr));
        System.out.println();
        int[] newArr = deleteElement(arr, 3);
        System.out.println("mảng sau khi xóa " + Arrays.toString(newArr));
    }
}