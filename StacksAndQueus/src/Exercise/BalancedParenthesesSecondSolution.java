package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParenthesesSecondSolution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());

        String result = isBalanced(input) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean isBalanced(List<String> input) {
        ArrayDeque<String> openParentheses = new ArrayDeque<>();

        for (String brace : input) {
            if(input.size() % 2 !=0){
                return false;
            }
            switch (brace){
                case "}":
                    String openBrace = openParentheses.pop();
                    if(!openBrace.equals("{")){
                        return false;
                    }
                    break;
                case "]":
                    openBrace = openParentheses.pop();
                    if(!openBrace.equals("[")){
                        return false;
                    }
                    break;
                case ")":
                    openBrace = openParentheses.pop();
                    if(!openBrace.equals("(")){
                        return false;
                    }
                    break;
                default:
                    openParentheses.push(brace);
            }
        }
        return openParentheses.isEmpty();
    }
}
