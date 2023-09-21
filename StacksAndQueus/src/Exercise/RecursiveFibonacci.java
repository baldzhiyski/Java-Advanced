package Exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memory;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int position = Integer.parseInt(scan.nextLine());



        memory = new long[position+1];
        long result = getFibonacci(position);
        System.out.println(result);

    }
    private static long getFibonacci(int position) {
        if(position < 2) {
            return 1;
        }
        if(memory[position] !=0 ){
            return memory[position];
        }
        memory[position] = getFibonacci(position -1) + getFibonacci(position -2);

        return memory[position];
    }
}
