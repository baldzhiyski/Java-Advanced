package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][]matrix = creatingMatrix(scan);

        calculateSumOfTwoDiagonals(matrix);
    }

    private static void calculateSumOfTwoDiagonals(int[][] matrix) {
        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            sumFirstDiagonal+=matrix[row][row];
        }
        int rowCounter = 0;
        for (int col = matrix.length-1; col>=0 ; col--) {
            sumSecondDiagonal+=matrix[rowCounter][col];
            rowCounter++;
        }
        System.out.println(Math.abs(sumFirstDiagonal-sumSecondDiagonal));
    }

    private static int[][] creatingMatrix(Scanner scan) {
        int sizeOfMatrix = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int row = 0; row < sizeOfMatrix; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}