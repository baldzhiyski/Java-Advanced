import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrixSecond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = creatingMatrix(scan, size, size);

        int rowFirstDiagonal = size - 1;
        int col = 0;
        int rowSecondDiagonal = 0;

        // Second Solution

        while (isInBounce(rowSecondDiagonal, col, matrix)) {
            System.out.print(matrix[rowSecondDiagonal][col] + " ");
            rowSecondDiagonal++;
            col++;
        }
        col = 0;
        System.out.println();


        while (isInBounce(rowFirstDiagonal, col, matrix)) {
            System.out.print(matrix[rowFirstDiagonal][col] + " ");
            rowFirstDiagonal--;
            col++;
        }
    }

    private static boolean isInBounce(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[col].length;
    }
    private static int[][] creatingMatrix(Scanner scan,int rows , int cols) {
        int[][] matrix = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                matrix[row] = arr;
            }
            return matrix;
        }
    }
