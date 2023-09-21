import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] firstMatrix = creatingMatrix(scan);
        int[][] secondMatrix = creatingMatrix(scan);

        boolean areEqual = compareMatrix(firstMatrix,secondMatrix);

        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);
    }
    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length!=secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if(firstArr.length!=secondArr.length){
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                int firstEl = firstArr[col];  // firstMatrix[row][col]
                int secondEl = secondArr[col]; // secondMatrix[row][col]
                if(firstEl!=secondEl){
                    return false;
                }
            }
        }
        return true;
    }
    private static int[][] creatingMatrix(Scanner scan) {
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

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
