import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumSubmatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(", ");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        int[][] matrix = creatingMatrix(scan,rows,cols);

       int topSum = Integer.MIN_VALUE;
       int[][] result = new int[2][2];
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int currentSum = matrix[row][col]
                        + matrix[row][col+1]
                        + matrix[row+1][col]
                        + matrix[row+1][col+1];
                if(topSum<currentSum) {
                    topSum = currentSum;
                    result = new int[][]{
                            {matrix[row][col],matrix[row][col+1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        printMethod(result);
        System.out.println(topSum);
    }
    private static void printMethod(int[][] result) {
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] creatingMatrix(Scanner scan,int rows , int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[]arr = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
