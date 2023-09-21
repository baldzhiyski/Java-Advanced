package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix =  creatingMatrix(scan);
        int topSum = Integer.MIN_VALUE;

        int bestRowIndex = -1;
        int bestColIndex = -1;


        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;
                for (int r = row; r < row+3; r++) {
                    for (int c = col; c <col+3 ; c++) {
                        currentSum+=matrix[r][c];
                    }
                }
                if(currentSum>topSum){
                    topSum=currentSum;
                    bestRowIndex=row;
                    bestColIndex=col;
                }
            }
        }
        System.out.println("Sum = " + topSum);
        printTheMatrixWithMaxSum(matrix,bestRowIndex,bestColIndex);
    }

    private static void printTheMatrixWithMaxSum(int[][] matrix, int bestRowIndex, int bestColIndex) {
        for (int row = bestRowIndex; row < bestRowIndex + 3; row++) {
            for (int col = bestColIndex; col < bestColIndex+3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] creatingMatrix(Scanner scan) {
        String[] data = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row]= Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
