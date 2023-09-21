import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = creatingMatrix(scan, size, size);

        for (int row = 0, currentCol = 0; row < size && currentCol < size; row++, currentCol++) {
            System.out.print(matrix[row][currentCol] + " ");
        }
        System.out.println();
        for (int row = size - 1, currentCol = 0; row >= 0 && currentCol <  size; row--, currentCol++) {
            System.out.print(matrix[row][currentCol] + " ");
        }
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
