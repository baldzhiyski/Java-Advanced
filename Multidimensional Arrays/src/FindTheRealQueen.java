import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = creatingMatrix(scan);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char symbol = matrix[row][col];
                if(symbol=='q' && isValidQueen(row,col,matrix)){
                    System.out.println(row+ " " + col );
                    return;
                }
            }
        }
    }
    private static boolean isValidQueen(int row, int col, char[][] matrix) {
        //left = col-- row(same)
        for (int currentCol = col-1; currentCol >= 0; currentCol--) {
            if(matrix[row][currentCol]=='q'){
                return false;
            }

        }
        //right= col++ row(same)
        for (int currentCol = col+1; currentCol < 8; currentCol++) {
            if(matrix[row][currentCol]=='q'){
                return false;
            }

        }
        //up =  row--; second iteration
        for (int currentRow = row-1; currentRow >= 0; currentRow--) {
            if(matrix[currentRow][col]=='q'){
                return false;
            }

        }
        //down = row++;
        for (int currentRow = row+1; currentRow < 8; currentRow++) {
            if(matrix[currentRow][col]=='q'){
                return false;
            }

        }
        // diagonals:
        // up-left = row--; col--; first iteration
        for (int currentRow = row-1 , currentCol = col-1 ;currentRow >= 0 && currentCol>=0; currentRow-- , currentCol--) {
            if(matrix[currentRow][currentCol]=='q'){
                return false;
            }
        }
        //up-right = row--; col++; third
        for (int currentRow = row-1 , currentCol = col+1 ;currentRow >= 0 && currentCol<8; currentRow-- , currentCol++) {
            if(matrix[currentRow][currentCol]=='q'){
                return false;
            }
        }
        //down-left = row++; col--;
        for (int currentRow = row+1 , currentCol = col-1 ;currentRow <8 && currentCol>=0; currentRow++ , currentCol--) {
            if(matrix[currentRow][currentCol]=='q'){
                return false;
            }
        }
        //down-right = row++; col++;
        for (int currentRow = row+1 , currentCol = col+1 ;currentRow < 8 && currentCol<8; currentRow++ , currentCol++) {
            if(matrix[currentRow][currentCol]=='q'){
                return false;
            }
        }
        return true;

    }
    private static char[][] creatingMatrix(Scanner scan) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scan.nextLine().replaceAll("\\s+","").toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
