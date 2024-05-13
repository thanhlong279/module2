package ex2_stop_watch;

import java.util.Random;

public class Test {
    // viết phương thức tạo 1 mảng các số nguyên ngẫu nhiên
    public static int[] randomArray(int size){
        // đối tượng rand tạo ra các số ngẫu nhiên
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = rand.nextInt();
        }
        return arr;
    }
    // thuật toán sắp xếp lựa chọn
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(100000);
        // tạo đối tượng
        StopWatch sw = new StopWatch();
        sw.start();
        selectionSort(arr);
        sw.stop();
        long elapsedTime = sw.getElapsedTime();
        System.out.println("thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số = "+ elapsedTime + " milliseconds");
    }
}
