package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] commands = scan.nextLine().split("[()]");

        String word = scan.nextLine();
        List<String> wordsList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        while (!word.equals("END")){
            wordsList.add(word);
            if(word.length()>maxLength){
                maxLength = word.length();
            }
            word=scan.nextLine();
        }
        int cols = maxLength;
        int rows = wordsList.size();
        char [][] matrix = new char[rows][cols];
        fillingMatrix(wordsList,matrix);
        int rotation = Integer.parseInt(commands[1]);
        switch (rotation%360){
            case 90:
                matrix=rotateMatrix90(matrix,rows,cols);
                break;
            case 180:
                matrix=rotateMatrix90(matrix,rows,cols);
                matrix=rotateMatrix90(matrix,cols,rows);
                break;
            case 270:
                matrix=rotateMatrix90(matrix,rows,cols);
                matrix=rotateMatrix90(matrix,cols,rows);
                matrix=rotateMatrix90(matrix,rows,cols);
                break;

        }
        printMethod(matrix);

    }

    private static void printMethod(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix90(char[][] matrix, int rows, int cols) {
        char[][] rotatedMatrix = new char[cols][rows];
        for (int col = 0; col < cols; col++) {
            int c =0;
            for (int row = rows-1; row >=0; row--) {
                rotatedMatrix[col][c++]= matrix[row][col];
            }
        }
        return rotatedMatrix;
    }


    private static void fillingMatrix(List<String> wordsList,char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String currentWord = wordsList.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col <currentWord.length()) {
                    char symbol = currentWord.charAt(col);
                    matrix[row][col] = symbol;
                }else{
                     matrix[row][col]= ' ';
                }
            }
        }
    }
}
