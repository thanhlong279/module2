import java.util.Scanner;

public class Ex1_InsertionSort {
    public static void insertionSort(int[] arr){
        int size = arr.length;
        for(int i = 1; i < size; i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
                printArray(arr);
            }
            arr[j+1] = key;
            printArray(arr);
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
        insertionSort(list);
        System.out.println("mang sau khi sap xep");
        printArray(list);
    }
}
