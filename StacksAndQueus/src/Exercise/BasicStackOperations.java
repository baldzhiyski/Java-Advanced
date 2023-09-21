package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        for (int i = 0; i < numbers[1]; i++) {
            stack.pop();
        }

        if(stack.isEmpty()){
            System.out.println(0);
        }else if(stack.contains(numbers[2])){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(stack));
        }
    }
}
