import java.util.Scanner;

public class PR1_BubbleSort {
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
        System.out.println(" sắp xếp: ");
        bubbleSortByStep(list);
    }

//    public static void bubbleSort(int[] list) {
//        boolean needNextPass = true;
//        for (int k = 1; k < list.length && needNextPass; k++) {
//            needNextPass = false;
//            for (int i = 0; i < list.length - k; i++) {
//                if (list[i] > list[i + 1]) {
//                    System.out.println("swap " + list[i] + " sang " + list[i + 1]);
//                    int temp = list[i];
//                    list[i] = list[i + 1];
//                    list[i + 1] = temp;
//                    needNextPass = true;
//                }
//            }
//            if (needNextPass == false) {
//                System.out.println("mang co the dc sap xep");
//                break;
//            }
//            System.out.println("danh sách sau khi sắp xếp: " + k + " sort");
//            for (int j = 0; j < list.length - 1; j++) {
//                System.out.println(list[j] + "\t");
//            }
//            System.out.println();
//        }
//    }
    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 0; k < list.length -1&& needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k- 1; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            /* Array may be sorted and next pass not needed */
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            /* Show the list after sort */
            System.out.print("mang sau khi sap xep  " + k + "' lan: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}

