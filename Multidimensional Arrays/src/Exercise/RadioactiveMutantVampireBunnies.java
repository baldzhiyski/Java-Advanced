package Exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        char[][] matrix = new char[rows][cols];
        int playerCurrentRowIndex = 0;
        int playerCurrentColIndex = 0;
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            for (int index = 0; index < input.toCharArray().length; index++) {
                char symbol = input.charAt(index);
                if (symbol == 'P') {
                    playerCurrentRowIndex = i;
                    playerCurrentColIndex = index;
                    symbol='.';
                }
                matrix[i][index] = symbol;
            }
        }
        boolean hasDied = false;
        boolean hasWon = false;
        String playerMovements = scanner.nextLine();
        for (int indexOfMovement = 0; indexOfMovement < playerMovements.toCharArray().length; indexOfMovement++) {
            char symbol = playerMovements.charAt(indexOfMovement);
            // We proceed with the movement of the player
            if (symbol == 'U') {
                if (playerCurrentRowIndex - 1 >= 0) {
                    playerCurrentRowIndex -= 1;
                    if (matrix[playerCurrentRowIndex][playerCurrentColIndex] == 'B') {
                        hasDied=true;
                    } else {
                        matrix[playerCurrentRowIndex][playerCurrentColIndex] = '.';
                    }

                }else{
                    hasWon=true;
                }
            } else if (symbol == 'D') {
                if (playerCurrentRowIndex + 1 < matrix.length) {
                    playerCurrentRowIndex += 1;
                    if (matrix[playerCurrentRowIndex][playerCurrentColIndex] == 'B') {
                        hasDied=true;
                    } else {
                        matrix[playerCurrentRowIndex][playerCurrentColIndex] = '.';
                    }

                }else{
                    hasWon=true;
                }

            } else if (symbol == 'L') {
                if (playerCurrentColIndex - 1 >= 0) {
                    playerCurrentColIndex -= 1;
                    if (matrix[playerCurrentRowIndex][playerCurrentColIndex] == 'B') {
                        hasDied=true;
                    } else {
                        matrix[playerCurrentRowIndex][playerCurrentColIndex] = '.';
                    }

                }else{
                    hasWon=true;
                }
            } else if (symbol == 'R') {
                if (playerCurrentColIndex + 1 < matrix[playerCurrentRowIndex].length) {
                    playerCurrentColIndex += 1;
                    if (matrix[playerCurrentRowIndex][playerCurrentColIndex] == 'B') {
                        hasDied=true;
                    } else {
                        matrix[playerCurrentRowIndex][playerCurrentColIndex] = '.';
                    }

                }else{
                    hasWon=true;
                }

            }
            // After the move we need to spread each Bunnie cell
            findingNewIndexesForBunnies(matrix, positions);
            fillingTheMatrixWithBunnies(matrix, positions);
            if(hasWon){
                printMatrix(matrix);
                System.out.printf("won: %d %d", playerCurrentRowIndex, playerCurrentColIndex);
                return;
            }
            if(matrix[playerCurrentRowIndex][playerCurrentColIndex]=='B'){
                hasDied=true;
            }
            positions.clear();
            if(hasDied){
                printMatrix(matrix);
                System.out.printf("dead: %d %d", playerCurrentRowIndex, playerCurrentColIndex);
                return;
            }

        }
    }
    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void fillingTheMatrixWithBunnies(char[][] matrix, List<Integer> positions) {
        for (int i = 0; i < positions.size()-1; i+=2) {
            int row = positions.get(i);
            int col = positions.get(i+1);
            matrix[row][col]='B';
        }
    }
    private static void findingNewIndexesForBunnies(char[][] matrix, List<Integer> positions) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]=='B'){
                    //up
                    if(row-1>=0){
                        positions.add(row-1);
                        positions.add(col);
                    }
                    //down
                    if(row+1<matrix.length){
                        positions.add(row+1);
                        positions.add(col);
                    }
                    //left
                    if(col-1>=0){
                        positions.add(row);
                        positions.add(col-1);
                    }
                    //right
                    if(col+1<matrix[row].length){
                        positions.add(row);
                        positions.add(col+1);

                    }
                }
            }
        }
    }

}
