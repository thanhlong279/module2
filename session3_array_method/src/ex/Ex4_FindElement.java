package ex;

import java.util.Scanner;

public class Ex4_FindElement {
    // tìm phần tử lớn nhất của mảng 2 chiều
    public static double[][] inputMatrix(){
        int row;
        int col;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("nhập số hàng của mảng: ");
            row = sc.nextInt();
            if(row <= 0){
                System.out.println("nhập lại 1 số nguyên lớn ơn 0.");
            }
        }while (row <= 0);

        do {
            System.out.println("nhập số cột của mảng: ");
            col = sc.nextInt();
            if(col <= 0){
                System.out.println("nhập lại 1 số nguyên lớn ơn 0.");
            }
        }while (col <= 0);

        double[][] matrix = new double[row][col];
        // nhập các giá trị của mảng 2 chiều:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập giá trị cho phần tử ở hàng %d cột %d: ", i + 1, j + 1);
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    public static double [] maxMatrix(double[][] matrix) {
        double max = matrix[0][0];
        int maxrow = 0;
        int maxcol = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxrow = i;
                    maxcol = j;
                }
            }
        }
        return new double[]{max, maxrow, maxcol};
    }

    public static void main(String[] args) {
        double[] maxMatrix = maxMatrix(inputMatrix());
        System.out.println("phần tử lớn nhất của ma trận: " + maxMatrix[0]);
        System.out.println("vị trí của phần tử lớn nhất ma trận: matrix[" + maxMatrix[1]+"][" +maxMatrix[2]+"]");
    }
}
