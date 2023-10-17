package Exam_26June_2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int pythonSize = 1;

        String[] commands = scan.nextLine().split(", ");
        char[][] field = creatingMatrix(scan,size);
        int[] currentPosition = findPosition(field);

        int currentRow = currentPosition[0];
        int currentCol = currentPosition[1];
        field[currentRow][currentCol]='*';

        int index=0;
        int food = foodCounter(field);
        boolean hasLost = false;
        while (index<commands.length && food>0 ){
            int newRow = currentRow;
            int newCol = currentCol;
            switch (commands[index]) {
                case "down":
                    newRow++;
                    if (newRow==size){
                        newRow=0;
                    }
                    break;
                case "up":
                    newRow--;
                    if (newRow<0){
                        newRow=size-1;
                    }
                    break;
                case "left":
                    newCol--;
                    if (newCol<0){
                        newCol=size-1;
                    }
                    break;
                case "right":
                    newCol++;
                    if (newCol==size){
                        newCol=0;
                    }
                    break;
            }
            currentRow=newRow;
            currentCol=newCol;
            if(field[newRow][newCol]=='e'){
                hasLost=true;
                System.out.println("You lose! Killed by an enemy!");
                break;
            }else if(field[newRow][newCol]=='f'){
                pythonSize++;
                food--;
                field[newRow][newCol]='*';
            }
            index++;

        }
        if(!hasLost){
            if(food >0){
                System.out.printf("You lose! There is still %d food to be eaten.",food);
            }else{
                System.out.printf("You win! Final python length is %d\n",pythonSize);
            }
        }
    }

    private static int foodCounter(char[][] field) {
        int num = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if(field[row][col]=='f'){
                    num++;
                }
            }
        }
        return num;
    }

    private static int[] findPosition(char[][] field) {
        int[] result = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int i1 = 0; i1 < field.length; i1++) {
                if(field[i][i1]=='s'){
                    result[0]=i;
                    result[1]=i1;
                }
            }
        }
        return result;
    }

    private static char[][] creatingMatrix(Scanner scan, int size) {
        char[][] result = new char[size][size];
        for (int row = 0; row < result.length; row++) {
            result[row]=scan.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return result;
    }
}
