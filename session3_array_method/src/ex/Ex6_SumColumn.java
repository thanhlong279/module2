package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6_SumColumn {
    //tính tổng các số ở 1 cột xác định
    public static int[][] inputMatrix() {
        int row;
        int col;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(" nhap so hang: ");
            row = sc.nextInt();
            if (row <= 0) {
                System.out.println(" nhap lai so hang lon hon 0.");
            }
        } while (row <= 0);

        do {
            System.out.println("nhap so cot: ");
            col = sc.nextInt();
            if (col <= 0) {
                System.out.println(" nhap lai so cot lon hon 0.");
            }
        } while (col <= 0);

        int[][] matrix = new int[row][col];
        // nhap cac phan tu cho matrix.
        for (int i = 0; i < row; i++) {
            System.out.printf("Nhập các giá trị cho hàng %d:\n", i + 1);
            for (int j = 0; j < col; j++) {
                System.out.println("Giá trị tại hàng "+ (i + 1)+ " cột : "+(j + 1));
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int sumColumn(int[][] matrix, int column) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += row[column];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = inputMatrix();
        int sumColumn = sumColumn(matrix, 1);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(sumColumn);
    }
}
