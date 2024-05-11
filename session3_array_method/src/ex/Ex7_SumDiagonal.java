package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7_SumDiagonal {
    // tính tổng các số ở đường chéo chính của ma trận vuông
    public static int[][] inputMatrix() {
        int size;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" nhập kích thước cho ma trận vuông: ");
            size = sc.nextInt();
            if (size <= 0) {
                System.out.println("kích thước ma trận lớn hơn 0.");
            }
        } while (size <= 0);
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.out.println(" giá trị hàng " + (i + 1));
            for (int j = 0; j < size; j++) {
                System.out.println("giá trị hàng " + (i + 1) + " cột " + (j + 1));
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = inputMatrix();
        int sumDiagonal = sumDiagonal(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(sumDiagonal);
    }
}
