package Exercise;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        String[][] matrix = creatingMatrix(scanner,rows,cols);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            if(isValid(input,rows,cols)){
                swappingMethod(matrix, input);
                printCurrentMatrix(matrix);
            }else{
                System.out.println("Invalid input!");
            }
            input=scanner.nextLine();
        }
    }

    private static void printCurrentMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String col : rows) {
                System.out.print(col + " " );
            }
            System.out.println();
        }
    }

    private static void swappingMethod(String[][] matrix, String input) {
        input = input.replace("swap","").replaceAll("\\s+"," ").trim();
        int row1 = Integer.parseInt(input.split("\\s+")[0]);
        int col1 = Integer.parseInt(input.split("\\s+")[1]);
        int row2 = Integer.parseInt(input.split("\\s+")[2]);
        int col2 = Integer.parseInt(input.split("\\s+")[3]);

        String element = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = element;
    }

    private static String[][] creatingMatrix(Scanner scan,int rows , int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row]= scan.nextLine().split("\\s+");
        }
        return matrix;
    }
    private static boolean isValid(String input,int rows,int cols){
        if(input.contains("swap") && input.split("\\s+").length==5){
            input = input.replace("swap","").replaceAll("\\s+"," ").trim();
            int row1 = Integer.parseInt(input.split("\\s+")[0]);
            int col1 = Integer.parseInt(input.split("\\s+")[1]);
            int row2 = Integer.parseInt(input.split("\\s+")[2]);
            int col2 = Integer.parseInt(input.split("\\s+")[3]);

            return row2<=rows-1 && row2>=0 && row1<= rows-1  && row1>=0 && col1<=cols-1 && col1>=0 && col2<=cols-1 && col2>=0;

        }else{
            return false;
        }
    }

}
