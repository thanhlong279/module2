package ex;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Ex1_AddElement {
    //thêm phần tử vào mảng
    public static int[] inputArray() {
        int size;
        int[] arr;

        Scanner sc = new Scanner(in);

        do {
            out.println(" nhập kích thước cho mảng: ");
            size = sc.nextInt();
            if (size <= 0) {
                out.println(" mời bạn nhập lại, kích thước mảng lớn hơn 0.");
            }
        } while (size <= 0);
        arr = new int[size];
        int i = 0;
        while (i < size) {
            out.println(" nhập phần tử " + i + " : ");
            arr[i] = sc.nextInt();
            i++;
        }
        return arr;
    }

    public static int[] addElement(int[] array, int index, int x) {
        if (index < 0 || index >= array.length) {
            out.println(" ko chèn đc phần tử vào mảng");
            return array;
        }
        // tao mang moi tang size len 1.
        int[] newArray = new int[array.length + 1];
        //dich phan tu sang phai de chen X
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = x;
        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static void main(String[] args) {
//       int[] arr = inputArray();
//        out.print("mang ban dau: " + Arrays.toString(inputArray()));
//        out.println();
        int[] newArr = addElement(inputArray(), 3, 7);
        out.print("mang sau khi them: " + Arrays.toString(newArr));
    }
}
