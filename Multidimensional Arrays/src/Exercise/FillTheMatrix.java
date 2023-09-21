package Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(", ");
        int size = Integer.parseInt(data[0]);
        String type = data[1];

        int[][] matrix = new int[size][size];

        if(type.equals("A")){
            fillMatrixTypeA(matrix);
        }else{
            fillMatrixTypeB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int col : rows) {
                System.out.print(col + " " );
            }
            System.out.println();
        }
    }

    private static void fillMatrixTypeB(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            if((col+1)%2!=0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col]=number++;
                }
            }else{
                for (int row = matrix.length-1; row >=0 ; row--) {
                    matrix[row][col]=number++;
                }
            }
        }
    }

    private static void fillMatrixTypeA(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = number++;
            }
        }
    }
}
