import java.util.Scanner;
public class Ex66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows, cols;
        System.out.println("Choose input method:");
        System.out.println("1. Enter matrix values manually");
        System.out.println("2. Use predefined (constant) matrices");
        int choice = scanner.nextInt();
        int[][] matrixA, matrixB;
        if (choice == 1) {
            System.out.print("Enter number of rows: ");
            rows = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            cols = scanner.nextInt();
            matrixA = new int[rows][cols];
            matrixB = new int[rows][cols];
            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("A[" + i + "][" + j + "]: ");
                    matrixA[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("B[" + i + "][" + j + "]: ");
                    matrixB[i][j] = scanner.nextInt();
                }
            }
        } else {
            rows = 3;
            cols = 3;
            matrixA = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            matrixB = new int[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
            };
            System.out.println("Using predefined 3x3 matrices:");
            printMatrix("Matrix A", matrixA);
            printMatrix("Matrix B", matrixB);
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        printMatrix("Sum of Matrix A and B", result);
        scanner.close();
    }
    public static void printMatrix(String title, int[][] matrix) {
        System.out.println(title + ":");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
        System.out.println();
    }
}
