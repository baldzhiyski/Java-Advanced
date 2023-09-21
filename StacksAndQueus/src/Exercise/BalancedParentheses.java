package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scan.nextLine();

        for (char c : input.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty() || !areParenthesesBrackets(stack.pop(), c)) {
                    // we check if the stack is Empty because the edge case : when we have odd number of brackets
                    System.out.println("NO");
                    return;
                }
            }
        }
        // We need to make sure that there is no elements left !
        if(stack.isEmpty()){
        System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static boolean areParenthesesBrackets(char firstBracket, char secondBracket) {
        return (firstBracket == '{' && secondBracket == '}')
                || (firstBracket == '[' && secondBracket == ']')
                || (firstBracket == '(' && secondBracket == ')');
    }
}
