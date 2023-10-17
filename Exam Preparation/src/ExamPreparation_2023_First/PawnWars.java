package ExamPreparation_2023_First;
import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] field = creatingField(scan);


        int[] findingBlackLocation = findBlack(field);
        int currentBlackRow = findingBlackLocation[0];
        int currentBlackCol = findingBlackLocation[1];

        int[] findingWhiteLocation = findWhite(field);
        int currentWhiteRow = findingWhiteLocation[0];
        int currentWhiteCol = findingWhiteLocation[1];

        while (isValidBlack(currentBlackRow,field) && isValidWhites(currentWhiteRow)){
            //white turn
            if(currentWhiteCol-1>=0 && field[currentWhiteRow-1][currentWhiteCol-1]=='b'){
                currentWhiteRow++;
                currentWhiteCol--;
                String coordinates = calculateLetter(currentBlackCol) + (field.length-currentBlackRow);
                System.out.printf("Game over! White capture on %s.\n",coordinates);
                break;
            }else if(currentWhiteCol+1<8&&field[currentWhiteRow-1][currentWhiteCol+1]=='b'){
                currentWhiteRow++;
                currentWhiteCol++;
                String coordinates = calculateLetter(currentBlackCol) + (field.length-currentBlackRow);
                System.out.printf("Game over! White capture on %s.\n",coordinates);
                break;
            }
            // moving the white
            field[currentWhiteRow][currentWhiteCol]='-';
            currentWhiteRow--;
            field[currentWhiteRow][currentWhiteCol]='w';

            //black turn
            if(currentBlackCol-1>=0 && field[currentBlackRow+1][currentBlackCol-1]=='w'){
                currentBlackRow++;
                currentBlackCol--;
                String coordinates = calculateLetter(currentBlackCol) + (field.length-currentBlackRow);
                System.out.printf("Game over! Black capture on %s.\n",coordinates);
                break;
            }else if(currentBlackCol+1<8 && field[currentBlackRow+1][currentBlackCol+1]=='w'){
                currentBlackRow++;
                currentBlackCol++;
                String coordinates = calculateLetter(currentBlackCol) + (field.length-currentBlackRow);
                System.out.printf("Game over! Black capture on %s.\n",coordinates);
                break;
            }
            //moving the black
            field[currentBlackRow][currentBlackCol]='-';
            currentBlackRow++;
            field[currentBlackRow][currentBlackCol]='b';
        }
        if(!isValidWhites(currentWhiteRow)){
            String coordinates = calculateLetter(currentWhiteCol) + "8";
            System.out.printf("Game over! White pawn is promoted to a queen at %s.\n",coordinates);
        }else if(!isValidBlack(currentBlackRow,field)){
            String coordinates = calculateLetter(currentBlackCol) + "1";
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.\n",coordinates);
        }
    }
    private static boolean isValidWhites(int currentRow){
        return currentRow>0;
    }
    private static boolean isValidBlack(int currentRow, char[][] field) {
        return currentRow<field.length-1;
    }

    private static int[] findWhite(char[][] field) {
        int[] result = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if(field[row][col]=='w'){
                    result[0]=row;
                    result[1]=col;
                }
            }
        }
        return result;
    }

    private static int[] findBlack(char[][] field) {
        int[] result = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if(field[row][col]=='b'){
                    result[0]=row;
                    result[1]=col;
                }
            }
        }
        return result;
    }

    private static char[][] creatingField(Scanner scan) {
        char[][] result = new char[8][8];
        for (int row = 0; row < result.length; row++) {
            result[row]=scan.nextLine().toCharArray();
        }
        return result;
    }
    private static String calculateLetter(int currentCol){
        char letter = (char)('a' + currentCol);
        return String.valueOf(letter);
    }
}