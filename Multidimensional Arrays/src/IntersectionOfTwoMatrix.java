import java.util.Scanner;

public class IntersectionOfTwoMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = creatingMatrix(scan,rows,cols);
        char[][] secondMatrix = creatingMatrix(scan,rows,cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstEl = firstMatrix[row][col];
                char secondEl = secondMatrix[row][col];
                char fillChar = firstEl== secondEl ? firstEl: '*';
                System.out.print(fillChar+ " ");
            }
            System.out.println();
        }
    }
    public static char[][] creatingMatrix(Scanner scan,int rows , int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scan.nextLine().replaceAll("\\s+","").toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
