package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrDim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[][] isOccupied = new boolean[arrDim[0]][arrDim[1]];
        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int desiredRow = Integer.parseInt(tokens[1]);
            int desiredCol = Integer.parseInt(tokens[2]);
            boolean hasFoundPlace = false;
            int traveledDistance = 1;
            traveledDistance += Math.abs(desiredRow - entryRow);
            // we have an entry row,so we need to see the distance between it and the desired one

            // then we need to add the distance to the desiredColumn, but first we should check if it is free
            if (!isOccupied[desiredRow][desiredCol]) {
                traveledDistance += desiredCol;
                isOccupied[desiredRow][desiredCol] = true;
                hasFoundPlace = true;
            } else {
                // if it is not free then we check somewhere in the left , then in the right
                for (int col = 1; col < isOccupied[desiredRow].length && !hasFoundPlace; col++) {
                    if (desiredCol - col > 0 && !isOccupied[desiredRow][desiredCol - col]){
                        isOccupied[desiredRow][desiredCol - col] = true;
                        hasFoundPlace = true;
                        traveledDistance += desiredCol - col;
                    }
                    // that is how we check the whole row whether it has still remaining places

                    if (!hasFoundPlace && desiredCol + col < isOccupied[desiredRow].length
                            && !isOccupied[desiredRow][desiredCol + col]){
                        isOccupied[desiredRow][desiredCol + col] = true;
                        hasFoundPlace = true;
                        traveledDistance += col + desiredCol;
                    }
                }
            }
            if (hasFoundPlace){
                System.out.println(traveledDistance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }
        }
    }
}
