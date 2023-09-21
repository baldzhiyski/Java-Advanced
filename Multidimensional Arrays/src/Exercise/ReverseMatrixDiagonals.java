package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillingMatrix(scanner,matrix);

        reverseMatrixDiagonals(rows,cols,matrix);

    }

    private static void reverseMatrixDiagonals(int rows, int cols , int[][] matrix) {
        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int c = col;
            int r = row;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r][c] + " ");
                r--;
                c++;
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static void fillingMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
