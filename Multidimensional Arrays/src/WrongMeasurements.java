import java.util.Arrays;
import java.util.Scanner;


public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = creatingMatrix(scan);
        String[] direction = scan.nextLine().split("\\s+");
        int rowIndex = Integer.parseInt(direction[0]);
        int colIndex = Integer.parseInt(direction[1]);

        int wrongNumberValue = matrix[rowIndex][colIndex];
        int newValue = 0;
        for (int row = 0; row <=matrix.length - 1; row++) {
            for (int col = 0; col <= matrix[row].length - 1; col++) {
                if(matrix[row][col]==wrongNumberValue) {
                    // checking if there are numbers
                    if((row-1)>=0 && matrix[row-1][col] !=wrongNumberValue){
                        newValue+=matrix[row-1][col];
                    }
                    if((col+1)<matrix[row].length && matrix[row][col+1] !=wrongNumberValue){
                        newValue+=matrix[row][col+1];
                    }
                    if((row+1)<matrix.length && matrix[row+1][col] !=wrongNumberValue){
                        newValue+=matrix[row+1][col];
                    }
                    if((col-1)>=0 && matrix[row][col-1] !=wrongNumberValue){
                        newValue+=matrix[row][col-1];
                    }
                    matrix[row][col]=newValue;
                    newValue=0;
                }
            }
        }
        printMethod(matrix);
    }
    private static void printMethod(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int col : ints) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    private static int[][] creatingMatrix(Scanner scan) {
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row]=arr;
        }
        return matrix;

    }
}
