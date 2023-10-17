package Exam_14December_2022;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] battleField = creatingMatrix(size,scan);
        int[] positionOfSubMarine = findIndexes(battleField);
        int currentRow = positionOfSubMarine[0];
        int currentCol = positionOfSubMarine[1];

        int timesHit = 0;
        int killedCruiser = 0;
        while (true){
            int newRow = currentRow;
            int newCol = currentCol;
            String command = scan.nextLine();
            switch (command){
                case "left":
                    newCol--;
                    break;
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "right":
                    newCol++;
                    break;
            }
            if(isValidPosition(newCol,newRow,size)){
                battleField[currentRow][currentCol]='-';
                currentRow=newRow;
                currentCol=newCol;
                if(battleField[currentRow][currentCol]=='*'){
                    battleField[currentRow][currentCol]='S';
                    timesHit++;
                    if(timesHit==3){
                        System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n",currentRow,currentCol);
                        break;
                    }
                }else if(battleField[currentRow][currentCol]=='C'){
                    battleField[currentRow][currentCol]='S';
                    killedCruiser++;
                    if(killedCruiser==3){
                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        break;
                    }
                }
            }
        }
        printFinalState(battleField);
    }

    private static void printFinalState(char[][] battleField) {
        for (int row = 0; row < battleField.length; row++) {
            for (int col = 0; col < battleField.length; col++) {
                System.out.print(battleField[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isValidPosition(int newCol, int newRow, int dimension) {
        return newCol>=0 && newCol<dimension && newRow>=0&& newRow<dimension;
    }
    private static int[] findIndexes(char[][] battleField) {
        int[] result = new int[2];
        for (int row = 0; row < battleField.length; row++) {
            for (int col = 0; col < battleField[row].length; col++) {
                if(battleField[row][col]=='S'){
                    result[0]=row;
                    result[1]=col;
                    break;
                }
            }
        }
        return result;
    }

    private static char[][] creatingMatrix(int size, Scanner scan) {
        char[][] result = new char[size][size];
        for (int row = 0; row < result.length; row++) {
            result[row] = scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return result;
    }
}
