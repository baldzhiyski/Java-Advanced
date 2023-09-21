package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int times = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < times; i++) {
            String input = scan.nextLine();
            if(input.length()==1){
                int number = Integer.parseInt(input.charAt(0) + "");
                if(number==2){
                    stack.pop();
                }else {
                    System.out.println(Collections.max(stack));
                }
            }else{
                int number = Integer.parseInt(input.split(" ")[1]);
                stack.push(number);
            }
        }
    }
}
