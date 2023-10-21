import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] field = creatingField(size,scan);
        int[] coordinates = findCoordinates(field);
        int currentRow = coordinates[0];
        int currentCol = coordinates[1];

        int quantity = 0;

        String command = scan.nextLine();
        while (!command.equals("collect the nets")) {
            int newRow = currentRow;
            int newCol = currentCol;
            switch (command) {
                case "down":
                    newRow++;
                    if(newRow==size){
                        newRow=0;
                    }
                    break;
                case "up":
                    newRow--;
                    if(newRow<0){
                        newRow=size-1;
                    }
                    break;
                case "left":
                    newCol--;
                    if(newCol<0){
                        newCol=size-1;
                    }
                    break;
                case "right":
                    newCol++;
                    if(newCol==size){
                        newCol=0;
                    }
                    break;
            }
            field[currentRow][currentCol]='-';
            currentRow= newRow;
            currentCol = newCol;
            char currentPosition = field[currentRow][currentCol];
            if (Character.isDigit(currentPosition)) {
                quantity+= Character.getNumericValue(currentPosition);
                field[currentRow][currentCol]='S';
            }else if(currentPosition=='W'){
                field[currentRow][currentCol]='S';
                System.out.print("You fell into a whirlpool! The ship sank and you lost the fish you caught.");
                System.out.printf(" Last coordinates of the ship: [%d,%d]\n",currentRow,currentCol);
                return;
            }else{
                field[currentRow][currentCol]='S';
            }
            command=scan.nextLine();
        }
        if(quantity<20){
            System.out.print("You didn't catch enough fish and didn't reach the quota! ");
            System.out.printf("You need %d tons of fish more.\n",20-quantity);
        }else{
                System.out.println("Success! You managed to reach the quota!");
        }
        if(quantity>0){
            System.out.printf("Amount of fish caught: %d tons.\n",quantity);
        }
        printMatrix(field);

    }

    private static void printMatrix(char[][] field) {
        for (char[] rows : field) {
            for (char cowls : rows) {
                System.out.print(cowls);
            }
            System.out.println();
        }
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
