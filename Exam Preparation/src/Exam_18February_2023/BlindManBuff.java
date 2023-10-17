package Exam_18February_2023;

import java.util.Arrays;
import java.util.Scanner;

public class BlindManBuff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        char[][] playground = creatMatrix(dimensions[0],dimensions[1],scan);

        int[] currentPosition = findCurrentPosition(playground);
        int currentRow = currentPosition[0];
        int currentCol = currentPosition[1];
        String command = scan.nextLine();
        int touchedOpponents = 0;
        int moves = 0;
        while (!command.equals("Finish")) {
            int newRow = currentRow;
            int newCol = currentCol;

            switch (command) {
                case "down":
                    newRow++;
                    break;
                case "up":
                    newRow--;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }
            if (isValidPosition(newRow, newCol, dimensions[0], dimensions[1]) && playground[newRow][newCol]!='O') {
                playground[currentRow][currentCol]='-';
                currentRow = newRow;
                currentCol = newCol;
                moves++;
                if(playground[currentRow][currentCol]=='P'){
                    touchedOpponents++;
                }
                playground[currentRow][currentCol]='B';
            }
            if(touchedOpponents==3){
                break;
            }
            command=scan.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,moves);
    }
    private static boolean isValidPosition(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static int[] findCurrentPosition(char[][] playground) {
        int[] result = new int[2];
        for (int row = 0; row < playground.length; row++) {
            for (int col = 0; col < playground[row].length; col++) {
                if(playground[row][col]=='B'){
                    result[0]=row;
                    result[1] = col;
                }
            }
        }
        return result;
    }

    private static char[][] creatMatrix(int row, int col, Scanner scan) {
        char[][] result = new char[row][col];
        for (int roww = 0; roww < result.length; roww++) {
            result[roww] = scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return result;
    }
}
