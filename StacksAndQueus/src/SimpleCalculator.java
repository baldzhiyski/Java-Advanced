import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        String operator = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : input) {
            if(s.equals("+") || s.equals("-")){
                operator=s;
            }else if(stack.isEmpty()){
                stack.push(s);
            }else{
                int currentNum = Integer.parseInt(s);
                int lastNum = Integer.parseInt(stack.pop());
                if(operator.equals("+")){
                    stack.push(String.valueOf(currentNum+lastNum));
                }else{
                    stack.push(String.valueOf(lastNum-currentNum));
                }
            }
        }
        System.out.println(stack.pop());
    }
}
