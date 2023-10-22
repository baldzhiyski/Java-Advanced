package Exam_17Dec_2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        char[][] neighbourhood = creatingField(size,scan);
        int[] santaCoordinates = findCoordinates(neighbourhood);
        int countNiceKids = findNumberNiceKids(neighbourhood);

        int currentSantaRow = santaCoordinates[0];
        int currentSantaCol = santaCoordinates[1];
        String command = scan.nextLine();
        while (!command.equals("Christmas morning") && presentsCount>0){
            int newRow = currentSantaRow;
            int newCol = currentSantaCol;
            switch (command){
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
                neighbourhood[currentSantaRow][currentSantaCol]='-';
                currentSantaRow=newRow;
                currentSantaCol=newCol;
                char currentPos = neighbourhood[currentSantaRow][currentSantaCol];
                if(currentPos=='V'){
                    presentsCount--;
                    neighbourhood[currentSantaRow][currentSantaCol]='S';
                }else if(currentPos=='X'){
                    neighbourhood[currentSantaRow][currentSantaCol]='S';
                }else if(currentPos=='C'){
                    int[] result = givingPresents(presentsCount,neighbourhood,currentSantaRow,currentSantaCol,countNiceKids);
                    presentsCount = result[0];
                    countNiceKids=result[1];

                    neighbourhood[currentSantaRow][currentSantaCol]='S';
                }
            }
            if(presentsCount<=0){
                System.out.println("Santa ran out of presents!");
                break;
            }
            command=scan.nextLine();
        }
        printMatrix(neighbourhood);
        if(findNumberNiceKids(neighbourhood)==0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.",countNiceKids);
        }else{
            System.out.printf("No presents for %d nice kid/s.",findNumberNiceKids(neighbourhood));
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static int findNumberNiceKids(char[][] matrix) {
        int number = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'V') {
                    number++;
                }
            }
        }
        return number;
    }

    private static int[] givingPresents(int presentsCount, char[][] neighbourhood, int currentSantaRow, int currentSantaCol, int countNiceKids) {
        int[] resultArr = new int[2];
        int result = presentsCount;
            if (neighbourhood[currentSantaRow - 1][currentSantaCol] == 'V') {
                result--;
                neighbourhood[currentSantaRow -1][currentSantaCol] = '-';
            }else if(neighbourhood[currentSantaRow - 1][currentSantaCol] == 'X'){
                result--;
                neighbourhood[currentSantaRow -1][currentSantaCol] = '-';
                countNiceKids++;
            }
            if (neighbourhood[currentSantaRow +1][currentSantaCol] =='V') {
                result--;
                neighbourhood[currentSantaRow + 1][currentSantaCol] = '-';
            }else if(neighbourhood[currentSantaRow +1][currentSantaCol] == 'X'){
                result--;
                neighbourhood[currentSantaRow +1][currentSantaCol] = '-';
                countNiceKids++;
            }
            if (neighbourhood[currentSantaRow][currentSantaCol -1] =='V') {
                result--;
                neighbourhood[currentSantaRow][currentSantaCol -1] = '-';
            }else if(neighbourhood[currentSantaRow][currentSantaCol-1] == 'X'){
                result--;
                neighbourhood[currentSantaRow][currentSantaCol-1] = '-';
                countNiceKids++;
            }
            if (neighbourhood[currentSantaRow][currentSantaCol + 1] == 'V') {
                result--;
                neighbourhood[currentSantaRow][currentSantaCol + 1] = '-';
            }
            else if(neighbourhood[currentSantaRow ][currentSantaCol+1] == 'X'){
                result--;
                neighbourhood[currentSantaRow][currentSantaCol+1] = '-';
                countNiceKids++;
            }
            resultArr[0]=result;
            resultArr[1] = countNiceKids;
            return  resultArr;
    }

    private static boolean isValidIndex(int newRow, int newCol, int size) {
        return newRow>=0 && newRow<size && newCol>=0 && newCol<size;
    }
    private static char[][] creatingField(int size, Scanner scan) {
        char[][] result = new char[size][size];
        for (int row = 0; row < result.length; row++) {
            result[row]=scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return result;
    }
    private static int[] findCoordinates(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
