package Exam_9August_2023;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoY {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] fieldDimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[][] field = creatingMatrix(fieldDimensions,scan);
        int[] startingCoordinates = findTheBoy(field);


        int startingRow = startingCoordinates[0];
        int startingCol = startingCoordinates[1];

        int firstSpotBRow = startingRow;
        int firstSpotBCol = startingCol;

        while (true){
            String command = scan.nextLine();
            int newRow = startingRow;
            int newCol = startingCol;
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
            if(isValidPosition(newRow,newCol,fieldDimensions[0],fieldDimensions[1])){
                if(field[newRow][newCol]!='*'){
                    startingRow=newRow;
                    startingCol=newCol;
                }
                if(field[startingRow][startingCol]=='A'){
                    System.out.println("Pizza is delivered on time! Next order...");
                    field[startingRow][startingCol]='P';
                    break;
                }else if(field[startingRow][startingCol]=='-'){
                    field[startingRow][startingCol]='.';
                }else if(field[startingRow][startingCol]=='P'){
                    System.out.println("Pizza is collected. 10 minutes for delivery.");
                    field[startingRow][startingCol]='R';
                }
            }else{
                field[firstSpotBRow][firstSpotBCol]=' ';
                System.out.println("The delivery is late. Order is canceled.");
                break;
            }
        }
        printMatrix(field);

    }

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isValidPosition(int currentRow, int currentCol, int rows, int cols) {
        return currentRow >= 0 && currentRow< rows && currentCol >= 0 && currentCol  < cols;
    }
    private static int[] findTheBoy(char[][] field) {
        int[] coordinates = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col]=='B'){
                    coordinates[0]=row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static char[][] creatingMatrix(int[] fieldDimensions, Scanner scan) {
        int rows = fieldDimensions[0];
        int cols = fieldDimensions[1];
        char[][] resultMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            resultMatrix[row]= scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return resultMatrix;
    }
}
