package ExamPreparationSecond_2023;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int health = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = creatingBattleField(size,scan);

        int[] positionOfHelen = findCoordinates(matrix,'H');
        int[] positionOfParis = findCoordinates(matrix,'P');

        int currentRowParis = positionOfParis[0];
        int currentColParis = positionOfParis[1];

        while (true){
            if(health<=0){
                System.out.printf("Paris died at %d;%d.\n",currentRowParis,currentColParis);
                matrix[currentRowParis][currentColParis]='X';
                break;
            }
            String[] commands = scan.nextLine().split("\\s+");
            int rowOfNewSpartan = Integer.parseInt(commands[1]);
            int colOfNewSpartan = Integer.parseInt(commands[2]);
            matrix[rowOfNewSpartan][colOfNewSpartan]='S';
            int newRow = currentRowParis;
            int newCol = currentColParis;
            switch (commands[0]){
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
            if(isValidIndex(newRow,newCol,size)){
                health--;
                matrix[currentRowParis][currentColParis]='-';
                currentRowParis=newRow;
                currentColParis=newCol;
                if(currentRowParis==positionOfHelen[0] && currentColParis==positionOfHelen[1]){
                    System.out.println("Paris has successfully abducted Helen! Energy left: "+ health);
                    matrix[currentRowParis][currentColParis]='-';
                    break;
                }
                if(matrix[currentRowParis][currentColParis]=='S'){
                    health-=2;
                    if(health<=0){
                        System.out.printf("Paris died at %d;%d.\n",currentRowParis,currentColParis);
                        matrix[currentRowParis][currentColParis]='X';
                        break;
                    }
                }
                matrix[currentRowParis][currentColParis]='P';
            }else{
                health--;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int newRow, int newCol, int size) {
        return newRow>=0 && newRow<size && newCol>=0 && newCol<size;
    }

    private static int[] findCoordinates(char[][] matrix,char symbol) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==symbol){
                    coordinates[0]=row;
                    coordinates[1]=col;
                }
            }
        }
        return coordinates;
    }

    private static char[][] creatingBattleField(int size, Scanner scan) {
        char[][] result = new char[size][size];
        for (int row = 0; row < result.length; row++) {
            result[row]=scan.nextLine().toCharArray();
        }
        return result;
    }
}
