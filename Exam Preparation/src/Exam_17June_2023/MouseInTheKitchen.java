package Exam_17June_2023;

import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(",");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        char[][] cupboard = createMatrix(rows, cols, scan);

        boolean isTrapped = false;
        boolean outOfRange = false;
        boolean happyMouse = false;

        int[] positionOfMouse = checkMousePosition(cupboard);
        int row = positionOfMouse[0];
        int col = positionOfMouse[1];

        String command = scan.nextLine();

        while (!command.equals("danger")) {
            int newRow = row;
            int newCol = col;

            // We need to know the previous one in the case when we go to '@' , because then we need to undo our move;
            int previousRow=row;
            int previousCol=col;

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

            if (isValidPosition(newRow, newCol, rows, cols)) {
                row = newRow;
                col = newCol;
                if (cupboard[row][col] == 'C') {
                    cupboard[row][col] = '*';
                    if (lastCheeseInCupboard(cupboard)) {
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        cupboard[row][col] = 'M';
                        happyMouse = true;
                        break;
                    }
                } else if (cupboard[row][col] == 'T') {
                    System.out.println("Mouse is trapped!");
                    cupboard[row][col] = 'M';
                    isTrapped = true;
                    break;
                } else if (cupboard[row][col] == '@') {
                    row=previousRow;
                    col=previousCol;
                }
            } else {
                outOfRange = true;
                System.out.println("No more cheese for tonight!");
                break;
            }

            command = scan.nextLine();
        }
        if (!isTrapped && !outOfRange && !happyMouse) {
            System.out.println("Mouse will come back later!");
        }
        cupboard[row][col] = 'M';
        printMatrix(cupboard);
    }

    private static boolean isValidPosition(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static void printMatrix(char[][] cupboard) {
        for (char[] row : cupboard) {
            System.out.println(new String(row));
        }
    }

    private static boolean lastCheeseInCupboard(char[][] cupboard) {
        for (char[] row : cupboard) {
            for (char cell : row) {
                if (cell == 'C') {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] checkMousePosition(char[][] cupboard) {
        int[] result = new int[2];
        for (int row = 0; row < cupboard.length; row++) {
            for (int col = 0; col < cupboard[row].length; col++) {
                if (cupboard[row][col] == 'M') {
                    result[0] = row;
                    result[1] = col;
                    cupboard[row][col]='*';
                    return result;
                }
            }
        }
        return result;
    }

    private static char[][] createMatrix(int rows, int cols, Scanner scan) {
        char[][] result = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String word = scan.nextLine();
            result[row] = word.toCharArray();
        }
        return result;
    }
}