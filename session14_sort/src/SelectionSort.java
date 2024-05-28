import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của mảng chưa sắp xếp
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            // Hiển thị mảng sau mỗi lần hoán đổi
            printArray(array);
        }
    }
    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập size cho mảng số nguyên: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] list = new int[size];
        System.out.println("nhập " + size + "value");
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("in danh sách: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " \t");
        }
        System.out.println("mang ban dau: ");
        printArray(list);
        System.out.println("cac buoc thuc hien thuat toan:");
        selectionSort(list);
        System.out.println("mang sau khi sap xep");
        printArray(list);
    }
}
