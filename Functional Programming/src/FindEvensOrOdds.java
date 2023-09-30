import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split("\\s+");

        int start = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);

        String condition = scan.nextLine();
        if(condition.equals("even")){
            printRange(start,end,n->n%2==0);
        }else{
            printRange(start,end,n->n%2!=0);
        }
    }
    public static void printRange(int begin, int end , IntPredicate predicate){
        IntStream.rangeClosed(begin,end)
                .filter(predicate)
                .forEach(n-> System.out.print(n+ " "));
    }
}
