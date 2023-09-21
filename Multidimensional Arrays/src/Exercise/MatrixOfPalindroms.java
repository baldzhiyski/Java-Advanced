package Exercise;
import java.util.Scanner;

public class MatrixOfPalindroms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        String[][] matrix = new String[rows][cols];

        fillingPalindromeMatrix(matrix,rows,cols);

        printMethod(matrix);
    }

    private static void printMethod(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillingPalindromeMatrix(String[][] matrix,int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstAndLastLetter = (char) ('a' + row);
                char fillingLetter = (char)('a' + row+ col);
                matrix[row][col]= "" + firstAndLastLetter+fillingLetter+firstAndLastLetter;
            }
        }
    }
}
