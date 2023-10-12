package Exam_12April_2023;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimension = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(", ");
        char[][] field = creatingMatrix(dimension,scan);
        int[] startingRowsCols = findSquirelPosition(field);
        int index = 0;
        int hazelNuts=0;

        int startingRow = startingRowsCols[0];
        int startingCol = startingRowsCols[1];

        int newRow = startingRow;
        int newCol = startingCol;
        while (true){
            if(index==commands.length){
                System.out.println("There are more hazelnuts to collect.");
                break;
            }
            String command = commands[index];
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
            if(isValidPosition(newCol,newRow,dimension)){

                char fieldPosition = field[newRow][newCol];
                if(fieldPosition=='h'){
                    hazelNuts++;
                    if(hazelNuts==3){
                        System.out.println("Good job! You have collected all hazelnuts!");
                        break;
                    }
                    field[newRow][newCol]='*';
                }else if(fieldPosition=='t'){
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    break;
                }
            }else{
                System.out.println("The squirrel is out of the field.");
                break;
            }
            index++;
        }
        System.out.println("Hazelnuts collected: "+ hazelNuts);
    }

    private static boolean isValidPosition(int newCol, int newRow, int dimension) {
        return newCol>=0 && newCol<dimension && newRow>=0&& newRow<dimension;
    }

    private static int[] findSquirelPosition(char[][] field) {
        int[] result = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col]=='s'){
                    result[0] = row;
                    result[1]= col;
                }
            }
        }
        return result;
    }

    private static char[][] creatingMatrix(int dimension, Scanner scan) {
        char[][] result = new char[dimension][dimension];
        for (int row = 0; row < result.length; row++) {
            result[row]=scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return result;
    }
}
