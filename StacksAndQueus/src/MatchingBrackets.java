import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        ArrayDeque<Integer> indexHolder = new ArrayDeque<>();
        for (int index = 0; index < string.length(); index++) {
            char  symbol = string.charAt(index);
            if(symbol=='('){
                indexHolder.push(index);
            }else if(symbol==')'){
                int indexOfLastOpenBracket = indexHolder.pop();
                System.out.println(string.substring(indexOfLastOpenBracket,index+1));
            }
        }
    }
}
